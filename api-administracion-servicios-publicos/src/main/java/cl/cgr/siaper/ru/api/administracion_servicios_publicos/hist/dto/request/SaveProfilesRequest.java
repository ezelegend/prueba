package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class SaveProfilesRequest {
    private String codigo;
    private List<Long> profileIds;
    private String calidadFirmante;
}