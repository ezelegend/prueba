package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MetodoFirmaDto {
    private Long id;
    private String codigo;
}