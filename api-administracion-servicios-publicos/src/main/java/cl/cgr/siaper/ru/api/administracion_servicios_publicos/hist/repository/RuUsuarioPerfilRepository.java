package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.repository;

import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.Perfil;
import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.RuUsuarioPerfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * Repository for RuUsuarioPerfil entity (RU_USUARIOS_PERFILES table).
 * Provides equivalent query methods to UsuarioPerfilRepository for dual-write operations.
 */
public interface RuUsuarioPerfilRepository extends JpaRepository<RuUsuarioPerfil, Long> {

    @Query("select rup.perfil from RuUsuarioPerfil rup where rup.ruUsuario.id = :ruUsuarioId")
    List<Perfil> findPerfilesByRuUsuarioId(Long ruUsuarioId);

    @Query("select rup from RuUsuarioPerfil rup where rup.ruUsuario.id = :ruUsuarioId and rup.perfil.id = :perfilId")
    Optional<RuUsuarioPerfil> findByRuUsuarioIdAndPerfilId(Long ruUsuarioId, Long perfilId);

    @Query("select rup from RuUsuarioPerfil rup where rup.ruUsuario.id = :ruUsuarioId")
    List<RuUsuarioPerfil> findByRuUsuarioId(Long ruUsuarioId);
}
