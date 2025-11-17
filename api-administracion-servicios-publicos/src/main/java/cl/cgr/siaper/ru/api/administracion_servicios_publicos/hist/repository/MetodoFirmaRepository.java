package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.repository;

import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.MetodoFirma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MetodoFirmaRepository extends JpaRepository<MetodoFirma, Long> {

    Optional<MetodoFirma> findByCodigo(String codigo);

    @Query("""
        select mfr.metodoFirma from cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.MetodoFirmaRelacion mfr
        where mfr.usuario.id = :usuarioId and mfr.servicio.id = :servicioId
        """)
    List<MetodoFirma> consultarMetodosFirma(Long usuarioId, Long servicioId);
}