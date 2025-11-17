package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.repository;

import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.Perfil;
import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.UsuarioPerfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsuarioPerfilRepository extends JpaRepository<UsuarioPerfil, Long> {

    @Query("select up.perfil from UsuarioPerfil up where up.usuario.id = :usuarioId")
    List<Perfil> findPerfilesByUsuarioId(Long usuarioId);

    @Query("select up from UsuarioPerfil up where up.usuario.id = :usuarioId and up.perfil.id = :perfilId")
    Optional<UsuarioPerfil> findByUsuarioIdAndPerfilId(Long usuarioId, Long perfilId);
}