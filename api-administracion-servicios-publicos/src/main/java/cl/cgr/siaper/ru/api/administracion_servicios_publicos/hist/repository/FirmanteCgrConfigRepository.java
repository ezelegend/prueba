package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.repository;

import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.FirmanteCgrConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FirmanteCgrConfigRepository extends JpaRepository<FirmanteCgrConfig, Long> {

    @Query("select f from FirmanteCgrConfig f where f.firmanteCgr.id = :firmanteId")
    List<FirmanteCgrConfig> findByFirmanteId(Long firmanteId);

    @Modifying
    @Query("update FirmanteCgrConfig f set f.activo = :activo where f.firmanteCgr.id = :firmanteId and f.servicioFirmante.id = :servicioId")
    void updateEstadoByFirmanteAndServicio(Long firmanteId, boolean activo, Long servicioId);
}