package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.dto.response;

import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.dto.ProfileDto;
import lombok.Data;

import java.util.List;

@Data
public class ProfilesFilterResponse {
    private List<ProfileDto> perfilesAsociados;
    private List<ProfileDto> perfilesDisponibles;
    private boolean verServicioFirma;
    private boolean verServicioVU;
    private boolean checkFirmante;
    private String calidadFirmante;
}