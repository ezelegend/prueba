package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.dto.response;

import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.dto.MetodoFirmaDto;
import lombok.Data;

import java.util.List;

@Data
public class MetodosFirmaResponse {
    private List<MetodoFirmaDto> asociados;
    private List<MetodoFirmaDto> disponibles;
    private boolean flagTieneFirmaHSM;
    private Boolean claveFirmaRandom;
}