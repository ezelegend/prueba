package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.repository;

import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.Servicio;
import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.Subrogacion;
import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubrogacionRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Subrogacion> consultarSubroganciasUsuario(Usuario usuario, Servicio servicio) {
        return consultarSubroganciasUsuario(usuario, servicio, null);
    }

    public List<Subrogacion> consultarSubroganciasUsuario(
            Usuario usuario, Servicio servicio, String codPerfil) {
        String query = "Select sub from Subrogacion sub where";
        if (usuario != null) {
            query += " (sub.usuarioSubrogado.id = :idSubrogado or sub.usuarioSubrogante.id = :idSubrogado)";
        }

        if (servicio != null) {
            query += " and sub.servicio.id = :idServicio";
        }

        if (StringUtils.isNotBlank(codPerfil)) {
            query += " and sub.perfil.nombre = :codPerfil";
        }

		/* anterior
        Query consulta = em.createQuery(query);
		 */

        //hibernate moderno
        Query qquery = em.createNativeQuery(query);

        if (usuario != null) {
            qquery.setParameter("idSubrogado", usuario.getId());
        }

        if (servicio != null) {
            qquery.setParameter("idServicio", servicio.getId());
        }

        if (StringUtils.isNotBlank(codPerfil)) {
            qquery.setParameter("codPerfil", codPerfil);
        }

        return qquery.getResultList();
    }

    public void delete(Subrogacion sub) {
        if (sub == null) return;
        Subrogacion managed = sub;
        if (!em.contains(sub)) {
            managed = em.find(Subrogacion.class, sub.getId());
        }
        if (managed != null) {
            em.remove(managed);
        }
    }

    public List<Subrogacion> consultarSubrogados(Usuario usuario, String perfilNombre) {
        if (usuario == null || StringUtils.isBlank(perfilNombre)) return List.of();
        String jpql = """
                select s
                from Subrogacion s
                where s.usuarioSubrogado.id = :idUser
                  and s.perfil.nombre = :perfil
                """;
        return em.createQuery(jpql, Subrogacion.class)
                .setParameter("idUser", usuario.getId())
                .setParameter("perfil", perfilNombre)
                .getResultList();
    }

}
