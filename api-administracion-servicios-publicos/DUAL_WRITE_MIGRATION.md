# Dual-Write Strategy and Migration Plan for User Administration Module

## Overview

This document describes the dual-write strategy implemented for the User Administration module to support the migration from legacy `TRA_*` tables to new `RU_*` tables. The approach ensures data consistency during the migration while maintaining system availability.

## Architecture

### New Tables (RU_*)

The following new tables have been created to mirror the existing TRA_* structure:

1. **RU_USUARIOS** - Replica of TRA_USUARIOS
2. **RU_USUARIOS_PERFILES** - Replica of TRA_USUARIOS_X_PERFILES
3. **RU_METODOS_FIRMA_RELACION** - Replica of TRA_METODOS_FIRMA_RELACION

### Extended Tables

Existing tables have been extended with foreign key fields to RU_USUARIOS:

1. **TRA_FIRMANTES_CGR**
   - Added: `USUA_RU_X_USUA` (FK to RU_USUARIOS)
   - Initially set to NULL, updated during dual-write operations

2. **TRA_SUBROGACIONES**
   - Added: `USUA_RU_X_USUA` (FK to RU_USUARIOS, subrogado/firmante)
   - Added: `USUA_RU_X_USUA_S` (FK to RU_USUARIOS, subrogante)
   - Initially set to NULL, updated during dual-write operations

## Dual-Write Implementation

### Affected Operations

All write operations in `UsersAdminServiceImpl` implement dual-write to both TRA and RU tables:

| Operation | TRA Tables Updated | RU Tables Updated |
|-----------|-------------------|-------------------|
| **saveUser()** | TRA_USUARIOS | RU_USUARIOS |
| **profilesSave()** | TRA_USUARIOS_X_PERFILES | RU_USUARIOS_PERFILES |
| **metodosFirmaSave()** | TRA_METODOS_FIRMA_RELACION | RU_METODOS_FIRMA_RELACION |
| **activateByCodigo()** | TRA_USUARIOS | RU_USUARIOS |
| **deactivateByCodigo()** | TRA_USUARIOS | RU_USUARIOS |
| **changeServiceByCodigo()** | TRA_USUARIOS | RU_USUARIOS |

### Transaction Guarantees

- All dual-write operations are wrapped in `@Transactional` annotations
- If any write to RU tables fails, the entire transaction is rolled back
- No partial writes occur - consistency is maintained across both table sets
- Detailed logging at DEBUG level tracks all dual-write operations

### Data Normalization

**RUN Normalization**: The `saveUser()` method normalizes RUN values by removing dots and spaces before persistence:
- Input: `"12.345.678-9"` or `"12 345 678-9"`
- Stored: `"12345678-9"`

**Email Preservation**: Email field is only updated when explicitly provided (not cleared if null in request).

## Migration Phases

### Phase 1: Dual-Write (Current State)

**Status**: ACTIVE  
**Configuration**: `usuarios.source.primary=TRA`

**Operations**:
- All writes go to both TRA and RU tables
- All reads come from TRA tables
- RU tables are kept in sync with TRA

**Validation**:
- Monitor dual-write success rates via logs
- Periodically verify data consistency between TRA and RU
- Address any synchronization failures

### Phase 2: Verification

**Status**: NOT STARTED  
**Configuration**: `usuarios.source.primary=TRA`

**Operations**:
- Continue dual-write
- Run data consistency checks
- Identify and fix any discrepancies
- Use `RuReconciliationService` to update FK references

**Validation Scripts**:
```sql
-- Verify user counts match
SELECT COUNT(*) FROM TRA_USUARIOS;
SELECT COUNT(*) FROM RU_USUARIOS;

-- Verify profiles match
SELECT USUA_X_USUA, COUNT(*) FROM TRA_USUARIOS_X_PERFILES GROUP BY USUA_X_USUA;
SELECT USUA_X_USUA, COUNT(*) FROM RU_USUARIOS_PERFILES GROUP BY USUA_X_USUA;

-- Verify signing methods match
SELECT USUA_X_USUA, COUNT(*) FROM TRA_METODOS_FIRMA_RELACION GROUP BY USUA_X_USUA;
SELECT USUA_X_USUA, COUNT(*) FROM RU_METODOS_FIRMA_RELACION GROUP BY USUA_X_USUA;
```

### Phase 3: Switch Primary Read Source

**Status**: NOT STARTED  
**Configuration**: `usuarios.source.primary=RU`

**Operations**:
- Dual-write continues
- Reads switch to RU tables (via `buildDetails()` adaptation)
- Monitor application performance and correctness
- Keep TRA as fallback

**Rollback Plan**:
- Change config back to `usuarios.source.primary=TRA`
- No code deployment needed for rollback

### Phase 4: Deactivate TRA as Primary

**Status**: NOT STARTED  
**Configuration**: `usuarios.source.primary=RU`

**Operations**:
- Gradually phase out TRA writes (optional)
- Keep TRA for audit/historical purposes
- RU becomes the single source of truth

## Configuration

### Application Configuration

The primary data source for read operations is controlled via `application.yaml`:

```yaml
usuarios:
  source:
    # Primary data source for read operations: TRA (legacy) or RU (new)
    # - TRA: reads from TRA_USUARIOS and related tables (default, current behavior)
    # - RU: reads from RU_USUARIOS and related tables (future state after migration)
    # Write operations always perform dual-write to both TRA and RU tables
    primary: TRA
```

### Reconciliation Service

The `RuReconciliationService` provides batch operations to update FK references in extended tables:

```java
// Inject the service
@Autowired
private RuReconciliationService ruReconciliationService;

// Reconcile all FirmanteCgr records
int firmantesUpdated = ruReconciliationService.reconcileFirmantes();

// Reconcile all Subrogacion records
int subrogacionesUpdated = ruReconciliationService.reconcileSubrogaciones();

// Reconcile everything
int totalUpdated = ruReconciliationService.reconcileAll();
```

## Monitoring and Debugging

### Log Levels

Enable detailed dual-write logging:

```yaml
logging:
  level:
    cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.service.impl.UsersAdminServiceImpl: DEBUG
```

### Key Log Messages

- `"Dual-write: syncing Usuario {codigo} to RuUsuario"`
- `"Dual-write: creating new RuUsuario for codigo {codigo}"`
- `"Dual-write: updating existing RuUsuario id={id} for codigo {codigo}"`
- `"Dual-write FAILED: error syncing Usuario {codigo} to RuUsuario - rolling back transaction"`
- `"Dual-write: synced {count} profiles to RU for user {codigo}"`
- `"Dual-write: synced {count} metodos firma to RU for user {codigo}"`

## Known Limitations and Considerations

1. **Performance Impact**: Dual-write doubles database write operations. Monitor performance during peak load.

2. **FK Constraints**: RU FK fields in TRA_FIRMANTES_CGR and TRA_SUBROGACIONES are initially NULL. Run reconciliation after bulk migrations.

3. **Sequence Management**: RU tables use separate sequences (`RU_S_USUA_X_USUA`, etc.). IDs will not match between TRA and RU.

4. **Cascade Deletes**: User deletion is not implemented. If needed, handle carefully for both TRA and RU.

5. **buildDetails() Migration**: The method currently reads from TRA only. Phase 3 requires adaptation to support RU as primary source.

## Testing Checklist

### Unit Tests (To Be Implemented)

- [ ] User creation performs dual-write to both TRA_USUARIOS and RU_USUARIOS
- [ ] Profile synchronization maintains consistency between TRA and RU
- [ ] Signing method synchronization works correctly
- [ ] Activate/deactivate reflects in both tables
- [ ] Service change updates both tables
- [ ] RUN normalization removes dots and spaces
- [ ] Email preservation doesn't clear existing values
- [ ] Transaction rollback on RU write failure

### Integration Tests (To Be Implemented)

- [ ] End-to-end user creation and retrieval
- [ ] Profile assignment and verification
- [ ] Signing method configuration
- [ ] FK reconciliation service execution
- [ ] Configuration property switching (TRA ↔ RU)

## Migration Scripts

### Initial Population (Optional)

To populate RU_* tables from existing TRA_* data:

```sql
-- Populate RU_USUARIOS from TRA_USUARIOS
INSERT INTO RU_USUARIOS (
    X_USUA, F_VERSION, SERV_X_SERV, C_USUARIO, T_RUN, T_NOMBRE,
    T_APELLIDO1, T_APELLIDO2, V_ORIGEN, L_ACTIVO, C_USUARIO_BLOQ,
    T_CORREO_ELECTRONICO, T_CONF_FIRMA, T_USUARIO_CONF_FIRMA_PDF, T_USUARIO_CONF_FIRMA
)
SELECT
    RU_S_USUA_X_USUA.NEXTVAL, F_VERSION, SERV_X_SERV, C_USUARIO, T_RUN, T_NOMBRE,
    T_APELLIDO1, T_APELLIDO2, V_ORIGEN, L_ACTIVO, C_USUARIO_BLOQ,
    T_CORREO_ELECTRONICO, T_CONF_FIRMA, T_USUARIO_CONF_FIRMA_PDF, T_USUARIO_CONF_FIRMA
FROM TRA_USUARIOS
WHERE NOT EXISTS (
    SELECT 1 FROM RU_USUARIOS WHERE C_USUARIO = TRA_USUARIOS.C_USUARIO
);

-- Populate RU_USUARIOS_PERFILES from TRA_USUARIOS_X_PERFILES
INSERT INTO RU_USUARIOS_PERFILES (X_USPE, F_VERSION, USUA_X_USUA, PERF_X_PERF, C_USUARIO_BLOQ)
SELECT
    RU_S_USPE_X_USPE.NEXTVAL, up.F_VERSION, ru.X_USUA, up.PERF_X_PERF, up.C_USUARIO_BLOQ
FROM TRA_USUARIOS_X_PERFILES up
INNER JOIN TRA_USUARIOS tu ON tu.X_USUA = up.USUA_X_USUA
INNER JOIN RU_USUARIOS ru ON ru.C_USUARIO = tu.C_USUARIO;

-- Populate RU_METODOS_FIRMA_RELACION from TRA_METODOS_FIRMA_RELACION
INSERT INTO RU_METODOS_FIRMA_RELACION (USUA_X_USUA, SERV_X_SERV, METO_X_METO, L_CLAVE_ALEATORIA, L_FIRMA_UNICA)
SELECT
    ru.X_USUA, mfr.SERV_X_SERV, mfr.METO_X_METO, mfr.L_CLAVE_ALEATORIA, mfr.L_FIRMA_UNICA
FROM TRA_METODOS_FIRMA_RELACION mfr
INNER JOIN TRA_USUARIOS tu ON tu.X_USUA = mfr.USUA_X_USUA
INNER JOIN RU_USUARIOS ru ON ru.C_USUARIO = tu.C_USUARIO;

-- Update FK references in TRA_FIRMANTES_CGR
UPDATE TRA_FIRMANTES_CGR fc
SET fc.USUA_RU_X_USUA = (
    SELECT ru.X_USUA FROM RU_USUARIOS ru
    INNER JOIN TRA_USUARIOS tu ON tu.C_USUARIO = ru.C_USUARIO
    WHERE tu.X_USUA = fc.USUA_X_USUA
)
WHERE fc.USUA_RU_X_USUA IS NULL;

-- Update FK references in TRA_SUBROGACIONES
UPDATE TRA_SUBROGACIONES s
SET s.USUA_RU_X_USUA = (
    SELECT ru.X_USUA FROM RU_USUARIOS ru
    INNER JOIN TRA_USUARIOS tu ON tu.C_USUARIO = ru.C_USUARIO
    WHERE tu.X_USUA = s.USUA_X_USUA
)
WHERE s.USUA_RU_X_USUA IS NULL;

UPDATE TRA_SUBROGACIONES s
SET s.USUA_RU_X_USUA_S = (
    SELECT ru.X_USUA FROM RU_USUARIOS ru
    INNER JOIN TRA_USUARIOS tu ON tu.C_USUARIO = ru.C_USUARIO
    WHERE tu.X_USUA = s.USUA_X_USUA_S
)
WHERE s.USUA_RU_X_USUA_S IS NULL;
```

## Support and Contact

For questions or issues related to the dual-write migration:

1. Check logs at DEBUG level for detailed operation traces
2. Review this document for architecture and phase information
3. Contact the development team for assistance

## Version History

| Version | Date | Author | Changes |
|---------|------|--------|---------|
| 1.0 | 2025-11-17 | System | Initial dual-write implementation |
