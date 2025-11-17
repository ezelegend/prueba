package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.dto.request;

import lombok.Data;

@Data
public class CheckDataRequest {
    private String run;
    private Long userId;
}