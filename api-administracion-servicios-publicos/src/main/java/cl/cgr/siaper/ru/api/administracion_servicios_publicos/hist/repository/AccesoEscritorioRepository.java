package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.repository;

import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.AccesoEscritorio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccesoEscritorioRepository extends JpaRepository<AccesoEscritorio, Long> {

    Optional<AccesoEscritorio> findByRunAndEstado(Long run, Integer estado);

}
