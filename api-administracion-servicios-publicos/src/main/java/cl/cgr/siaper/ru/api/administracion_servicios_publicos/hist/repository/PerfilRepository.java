package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.repository;

import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
}