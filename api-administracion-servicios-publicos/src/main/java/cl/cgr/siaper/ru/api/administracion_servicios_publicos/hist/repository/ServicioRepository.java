package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.repository;

import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface ServicioRepository extends JpaRepository<Servicio, Long> {

    // Filtrar IDs solo por activos
    @Query("select s.id from Servicio s where s.id in :ids and s.activo = true")
    List<Long> filterActive(@Param("ids") Collection<Long> ids);

    @Query("""
    select s
    from Servicio s join s.tipoServicio t
    where s.activo = true
      and t.codigo = 'CONTR'
    order by s.descripcion
""")
    List<Servicio> obtenerContralorias();

}
