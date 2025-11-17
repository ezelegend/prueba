package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class SaveServiciosRequest {
    private String codigo; // usuario
    private List<Long> serviceIds;
}