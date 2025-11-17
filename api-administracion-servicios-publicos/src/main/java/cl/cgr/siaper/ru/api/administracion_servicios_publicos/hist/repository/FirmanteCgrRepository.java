package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.repository;

import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.FirmanteCgr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FirmanteCgrRepository extends JpaRepository<FirmanteCgr, Long> {

    @Query("select f from FirmanteCgr f where f.usuarioFirmanteCgr.id = :usuarioId")
    List<FirmanteCgr> findByUsuarioId(Long usuarioId);
}