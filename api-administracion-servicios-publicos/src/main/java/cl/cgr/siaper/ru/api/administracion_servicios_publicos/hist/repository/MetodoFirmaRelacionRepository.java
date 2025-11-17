package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.repository;

import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.MetodoFirmaRelacion;
import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.MetodoFirmaRelacionPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MetodoFirmaRelacionRepository extends JpaRepository<MetodoFirmaRelacion, MetodoFirmaRelacionPK> {

    @Query("""
        select m from MetodoFirmaRelacion m
        where m.usuario.id = :usuarioId and m.servicio.id = :servicioId and m.metodoFirma.id = :metodoId
        """)
    Optional<MetodoFirmaRelacion> findByIds(Long usuarioId, Long servicioId, Long metodoId);

    @Query("""
        select m from MetodoFirmaRelacion m
        where m.usuario.id = :usuarioId and m.servicio.id = :servicioId
        """)
    List<MetodoFirmaRelacion> findByUsuarioIdAndServicioId(Long usuarioId, Long servicioId);
}