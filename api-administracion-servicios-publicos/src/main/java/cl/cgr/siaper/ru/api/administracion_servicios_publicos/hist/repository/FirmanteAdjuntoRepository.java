package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.repository;

import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.FirmanteAdjunto;
import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FirmanteAdjuntoRepository extends JpaRepository<FirmanteAdjunto, Long> {

    @Query("select f from FirmanteAdjunto f where f.usuarioFirmante.id = :usuarioId and f.servicioFirmante.id = :servicioId")
    Optional<FirmanteAdjunto> findByUsuarioAndServicio(Long usuarioId, Long servicioId);

    @Query("select f.servicioFirmante from FirmanteAdjunto f where f.usuarioFirmante.id = :usuarioId")
    List<Servicio> findServiciosByUsuarioFirmanteId(Long usuarioId);

    @Query("select f from FirmanteAdjunto f where f.usuarioFirmante.id = :usuarioId")
    List<FirmanteAdjunto> findByUsuarioFirmanteId(Long usuarioId);
}