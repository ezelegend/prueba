package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.Usuario;
import jakarta.persistence.EntityManager;

@Repository
public class UsersRepository {

	private static final Logger log = LoggerFactory.getLogger(UsersRepository.class);
	
	@Autowired
	private EntityManager em;


	public List<Usuario> getListUsers(String str) {
		if (str != null && !"".equals(str)) {
			String query = "from Usuario u where (upper(u.run) like upper(:cod) or " +
					"quitaracentos(u.codigo) like quitaracentos(:cod) or quitaracentos(u.nombre) like quitaracentos(:cod) " +
					"or quitaracentos(u.apellido1) like quitaracentos(:cod) or quitaracentos(u.apellido2) " +
					"like quitaracentos(:cod)) and u.activo = true order by u.nombre";
			return em.createQuery(query).setParameter("cod", "%" + str + "%").getResultList();
		}
		else {
			String query = "from Usuario u where u.activo = true order by u.nombre";
			return em.createQuery(query).getResultList();
		}
	}


	public List<Usuario> getListUsersNoActive(String str) {
		if (str != null && !"".equals(str)) {
			String query = "from Usuario u where (upper(u.run) like upper(:cod) or " +
					"quitaracentos(u.codigo) like quitaracentos(:cod) or quitaracentos(u.nombre) like quitaracentos(:cod) " +
					"or quitaracentos(u.apellido1) like quitaracentos(:cod) or quitaracentos(u.apellido2) " +
					"like quitaracentos(:cod)) and u.activo = false order by u.nombre";
			return em.createQuery(query).setParameter("cod", "%" + str + "%").getResultList();
		}
		else {
			String query = "from Usuario u where u.activo = false order by u.nombre";
			return em.createQuery(query).getResultList();
		}
	}

    public List<Usuario> searchActivos(String q) {
        String term = q == null ? "" : q.trim();
        String jpql = """
        select u from Usuario u
        where (
               :q = '' 
            or lower(u.codigo)    like lower(concat('%', :q, '%'))
            or lower(u.run)       like lower(concat('%', :q, '%'))
            or lower(u.nombre)    like lower(concat('%', :q, '%'))
            or lower(u.apellido1) like lower(concat('%', :q, '%'))
            or lower(u.apellido2) like lower(concat('%', :q, '%'))
        )
          and u.activo = true
        order by u.nombre, u.apellido1, u.apellido2
        """;
        return em.createQuery(jpql, Usuario.class)
                .setParameter("q", term)
                .getResultList();
    }

    public Optional<Usuario> findByCodigo(String codigo) {
        if (codigo == null || codigo.isBlank()) return Optional.empty();
        String jpql = "select u from Usuario u where u.codigo = :codigo";
        return em.createQuery(jpql, Usuario.class)
                .setParameter("codigo", codigo)
                .setMaxResults(1)
                .getResultList()
                .stream()
                .findFirst();
    }

    public List<Usuario> searchInactivos(String q) {
        String term = q == null ? "" : q.trim();
        String jpql = """
        select u from Usuario u
        where (
               :q = '' 
            or lower(u.codigo)     like lower(concat('%', :q, '%'))
            or lower(u.run)        like lower(concat('%', :q, '%'))
            or lower(u.nombre)     like lower(concat('%', :q, '%'))
            or lower(u.apellido1)  like lower(concat('%', :q, '%'))
            or lower(u.apellido2)  like lower(concat('%', :q, '%'))
        )
          and (u.activo = false or u.activo is null)
        order by u.nombre, u.apellido1, u.apellido2
        """;
        return em.createQuery(jpql, Usuario.class)
                .setParameter("q", term)
                .getResultList();
    }

    public List<Usuario> searchByRun(String run) {
        if (run == null || run.isBlank()) {
            return new ArrayList<>();
        }
        String jpql = "select u from Usuario u where upper(u.run) = upper(:run)";
        return em.createQuery(jpql, Usuario.class)
                .setParameter("run", run.trim())
                .getResultList();
    }

    public Optional<Usuario> findByRunOrCodigo(String run, String codigo) {
        String r = (run == null) ? null : run.trim();
        String c = (codigo == null) ? null : codigo.trim();

        if ((r == null || r.isEmpty()) && (c == null || c.isEmpty())) {
            return Optional.empty();
        }

        String jpql = """
        select u from Usuario u
        where (
               (:run is not null and :run <> '' and lower(u.run) = lower(:run))
            or (:codigo is not null and :codigo <> '' and lower(u.codigo) = lower(:codigo))
        )
        """;

        return em.createQuery(jpql, Usuario.class)
                .setParameter("run", r)
                .setParameter("codigo", c)
                .setMaxResults(1)
                .getResultList()
                .stream()
                .findFirst();
    }

    public Optional<Usuario> findById(Long id) {
        if (id == null) return Optional.empty();
        String jpql = "select u from Usuario u where u.id = :id";
        return em.createQuery(jpql, Usuario.class)
                .setParameter("id", id)
                .setMaxResults(1)
                .getResultList()
                .stream()
                .findFirst();
    }

    public Usuario save(Usuario u) {
        if (u == null) return null;
        if (u.getId() == null) {
            em.persist(u);
            return u;
        } else {
            return em.merge(u);
        }
    }


}
