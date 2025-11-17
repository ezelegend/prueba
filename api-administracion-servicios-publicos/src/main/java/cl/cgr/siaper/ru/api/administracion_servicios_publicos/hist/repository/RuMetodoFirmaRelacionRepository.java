package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.repository;

import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.RuMetodoFirmaRelacion;
import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.RuMetodoFirmaRelacionPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * Repository for RuMetodoFirmaRelacion entity (RU_METODOS_FIRMA_RELACION table).
 * Provides equivalent query methods to MetodoFirmaRelacionRepository for dual-write operations.
 */
public interface RuMetodoFirmaRelacionRepository extends JpaRepository<RuMetodoFirmaRelacion, RuMetodoFirmaRelacionPK> {

    @Query("""
        select rm from RuMetodoFirmaRelacion rm
        where rm.ruUsuario.id = :ruUsuarioId and rm.servicio.id = :servicioId and rm.metodoFirma.id = :metodoId
        """)
    Optional<RuMetodoFirmaRelacion> findByIds(Long ruUsuarioId, Long servicioId, Long metodoId);

    @Query("""
        select rm from RuMetodoFirmaRelacion rm
        where rm.ruUsuario.id = :ruUsuarioId and rm.servicio.id = :servicioId
        """)
    List<RuMetodoFirmaRelacion> findByRuUsuarioIdAndServicioId(Long ruUsuarioId, Long servicioId);
}
