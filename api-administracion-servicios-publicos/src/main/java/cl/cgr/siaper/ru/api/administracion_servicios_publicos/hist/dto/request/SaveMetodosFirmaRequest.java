package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class SaveMetodosFirmaRequest {
    private String codigo;
    private Long servicioId;
    private List<Long> metodoIds;
    private Boolean claveRandom;
}