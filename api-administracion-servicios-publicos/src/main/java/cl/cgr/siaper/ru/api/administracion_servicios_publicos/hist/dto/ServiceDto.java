package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServiceDto {
    private Long id;
    private String descripcion;
}