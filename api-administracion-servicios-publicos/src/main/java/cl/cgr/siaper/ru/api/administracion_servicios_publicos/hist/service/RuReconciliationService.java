package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.service;

import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.*;
import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service for reconciling RU_* foreign key references in TRA_FIRMANTES_CGR and TRA_SUBROGACIONES.
 * 
 * <p>This service provides batch reconciliation methods to update FK fields that were initially
 * set to -1 or NULL when RU_USUARIOS records didn't exist. Once RU_USUARIOS is populated,
 * these methods can be run to establish proper FK relationships.</p>
 * 
 * <h3>Usage:</h3>
 * <pre>
 * // Reconcile all firmantes with missing RU references
 * int updated = ruReconciliationService.reconcileFirmantes();
 * 
 * // Reconcile all subrogaciones with missing RU references
 * int updated = ruReconciliationService.reconcileSubrogaciones();
 * </pre>
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class RuReconciliationService {

    private final FirmanteCgrRepository firmanteCgrRepo;
    private final SubrogacionRepository subrogacionRepo;
    private final UsersRepository usuarioRepo;
    private final RuUsuarioRepository ruUsuarioRepo;

    /**
     * Reconciles FirmanteCgr records to link them to their corresponding RuUsuario.
     * Updates records where ruUsuario is null by matching on usuario codigo.
     * 
     * @return number of FirmanteCgr records updated
     */
    @Transactional
    public int reconcileFirmantes() {
        log.info("Starting reconciliation of FirmanteCgr records with RuUsuario");
        int updated = 0;

        List<FirmanteCgr> firmantes = firmanteCgrRepo.findAll();
        for (FirmanteCgr firmante : firmantes) {
            if (firmante.getRuUsuario() == null && firmante.getUsuarioFirmanteCgr() != null) {
                String codigo = firmante.getUsuarioFirmanteCgr().getCodigo();
                if (codigo == null) continue;

                RuUsuario ruUsuario = ruUsuarioRepo.findByCodigo(codigo).orElse(null);
                if (ruUsuario != null) {
                    firmante.setRuUsuario(ruUsuario);
                    firmanteCgrRepo.save(firmante);
                    updated++;
                    log.debug("Reconciled FirmanteCgr id={} to RuUsuario id={}", firmante.getId(), ruUsuario.getId());
                } else {
                    log.debug("FirmanteCgr id={}: RuUsuario not found for codigo {}", firmante.getId(), codigo);
                }
            }
        }

        log.info("Reconciliation complete: updated {} FirmanteCgr records", updated);
        return updated;
    }

    /**
     * Reconciles Subrogacion records to link them to their corresponding RuUsuario.
     * Updates records where ruUsuarioSubrogado or ruUsuarioSubrogante is null
     * by matching on usuario codigo.
     * 
     * @return number of Subrogacion records updated
     */
    @Transactional
    public int reconcileSubrogaciones() {
        log.info("Starting reconciliation of Subrogacion records with RuUsuario");
        int updated = 0;

        List<Subrogacion> subrogaciones = subrogacionRepo.findAll();
        for (Subrogacion subrogacion : subrogaciones) {
            boolean needsUpdate = false;

            // Reconcile subrogado
            if (subrogacion.getRuUsuarioSubrogado() == null && subrogacion.getUsuarioSubrogado() != null) {
                String codigo = subrogacion.getUsuarioSubrogado().getCodigo();
                if (codigo != null) {
                    RuUsuario ruSubrogado = ruUsuarioRepo.findByCodigo(codigo).orElse(null);
                    if (ruSubrogado != null) {
                        subrogacion.setRuUsuarioSubrogado(ruSubrogado);
                        needsUpdate = true;
                        log.debug("Reconciled Subrogacion id={} subrogado to RuUsuario id={}", subrogacion.getId(), ruSubrogado.getId());
                    }
                }
            }

            // Reconcile subrogante
            if (subrogacion.getRuUsuarioSubrogante() == null && subrogacion.getUsuarioSubrogante() != null) {
                String codigo = subrogacion.getUsuarioSubrogante().getCodigo();
                if (codigo != null) {
                    RuUsuario ruSubrogante = ruUsuarioRepo.findByCodigo(codigo).orElse(null);
                    if (ruSubrogante != null) {
                        subrogacion.setRuUsuarioSubrogante(ruSubrogante);
                        needsUpdate = true;
                        log.debug("Reconciled Subrogacion id={} subrogante to RuUsuario id={}", subrogacion.getId(), ruSubrogante.getId());
                    }
                }
            }

            if (needsUpdate) {
                subrogacionRepo.save(subrogacion);
                updated++;
            }
        }

        log.info("Reconciliation complete: updated {} Subrogacion records", updated);
        return updated;
    }

    /**
     * Runs full reconciliation for both FirmanteCgr and Subrogacion.
     * 
     * @return total number of records updated
     */
    @Transactional
    public int reconcileAll() {
        log.info("Starting full reconciliation of RU references");
        int firmantesUpdated = reconcileFirmantes();
        int subrogacionesUpdated = reconcileSubrogaciones();
        int total = firmantesUpdated + subrogacionesUpdated;
        log.info("Full reconciliation complete: {} total records updated", total);
        return total;
    }
}
