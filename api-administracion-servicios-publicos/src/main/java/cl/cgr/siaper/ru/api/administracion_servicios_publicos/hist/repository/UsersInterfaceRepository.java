package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.Usuario;

public interface UsersInterfaceRepository extends JpaRepository<Usuario, Long> {

    @EntityGraph(attributePaths = "servicio")
    @Query("""
            select u
            from Usuario u
            where u.activo = true
            """)
    Page<Usuario> getListUsersPageable(Pageable pageable);

    @EntityGraph(attributePaths = "servicio")
    @Query("""
            select u
            from Usuario u
            where u.activo = true
              and (
                  :q is null
                  or :q = ''
                  or lower(u.run) like lower(concat('%', :q, '%'))
                  or lower(u.codigo) like lower(concat('%', :q, '%'))
                  or lower(concat(u.nombre, ' ', u.apellido1, ' ', u.apellido2)) like lower(concat('%', :q, '%'))
              )
            """)
    Page<Usuario> getListUsersPageable(@Param("q") String q, Pageable pageable);

    @EntityGraph(attributePaths = "servicio")
    @Query("""
            select u
            from Usuario u
            where u.activo = false
            """)
    Page<Usuario> getListUsersNoActivePageable(Pageable pageable);

    @EntityGraph(attributePaths = "servicio")
    @Query("""
            select u
            from Usuario u
            where u.activo = false
              and (
                  :q is null
                  or :q = ''
                  or lower(u.run) like lower(concat('%', :q, '%'))
                  or lower(u.codigo) like lower(concat('%', :q, '%'))
                  or lower(concat(u.nombre, ' ', u.apellido1, ' ', u.apellido2)) like lower(concat('%', :q, '%'))
              )
            """)
    Page<Usuario> getListUsersNoActivePageable(@Param("q") String q, Pageable pageable);

}