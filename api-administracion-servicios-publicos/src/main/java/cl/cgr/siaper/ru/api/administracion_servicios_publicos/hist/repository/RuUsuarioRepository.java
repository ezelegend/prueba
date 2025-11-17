package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.repository;

import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.RuUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import java.util.Optional;

/**
 * Repository for RuUsuario entity (RU_USUARIOS table).
 * Provides equivalent query methods to UsersRepository for dual-write operations.
 */
@Repository
public class RuUsuarioRepository {

    @Autowired
    private EntityManager em;

    public Optional<RuUsuario> findByCodigo(String codigo) {
        if (codigo == null || codigo.isBlank()) return Optional.empty();
        String jpql = "select ru from RuUsuario ru where ru.codigo = :codigo";
        return em.createQuery(jpql, RuUsuario.class)
                .setParameter("codigo", codigo)
                .setMaxResults(1)
                .getResultList()
                .stream()
                .findFirst();
    }

    public Optional<RuUsuario> findByRun(String run) {
        if (run == null || run.isBlank()) return Optional.empty();
        String jpql = "select ru from RuUsuario ru where upper(ru.run) = upper(:run)";
        return em.createQuery(jpql, RuUsuario.class)
                .setParameter("run", run.trim())
                .setMaxResults(1)
                .getResultList()
                .stream()
                .findFirst();
    }

    public Optional<RuUsuario> findByRunOrCodigo(String run, String codigo) {
        String r = (run == null) ? null : run.trim();
        String c = (codigo == null) ? null : codigo.trim();

        if ((r == null || r.isEmpty()) && (c == null || c.isEmpty())) {
            return Optional.empty();
        }

        String jpql = """
        select ru from RuUsuario ru
        where (
               (:run is not null and :run <> '' and lower(ru.run) = lower(:run))
            or (:codigo is not null and :codigo <> '' and lower(ru.codigo) = lower(:codigo))
        )
        """;

        return em.createQuery(jpql, RuUsuario.class)
                .setParameter("run", r)
                .setParameter("codigo", c)
                .setMaxResults(1)
                .getResultList()
                .stream()
                .findFirst();
    }

    public Optional<RuUsuario> findById(Long id) {
        if (id == null) return Optional.empty();
        String jpql = "select ru from RuUsuario ru where ru.id = :id";
        return em.createQuery(jpql, RuUsuario.class)
                .setParameter("id", id)
                .setMaxResults(1)
                .getResultList()
                .stream()
                .findFirst();
    }

    public RuUsuario save(RuUsuario ru) {
        if (ru == null) return null;
        if (ru.getId() == null) {
            em.persist(ru);
            return ru;
        } else {
            return em.merge(ru);
        }
    }

    public void delete(RuUsuario ru) {
        if (ru != null) {
            em.remove(em.contains(ru) ? ru : em.merge(ru));
        }
    }
}
