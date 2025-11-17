package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.repository;

import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.Servicio;
import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.UsuarioServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsuarioServicioRepository extends JpaRepository<UsuarioServicio, Long> {

    @Query("select us from UsuarioServicio us where us.usuario.id = :usuarioId and us.servicio.id = :servicioId")
    Optional<UsuarioServicio> findByUsuarioIdAndServicioId(Long usuarioId, Long servicioId);

    @Query("select us.servicio from UsuarioServicio us where us.usuario.id = :usuarioId and us.activo = true")
    List<Servicio> findServiciosActivosByUsuarioId(Long usuarioId);
}