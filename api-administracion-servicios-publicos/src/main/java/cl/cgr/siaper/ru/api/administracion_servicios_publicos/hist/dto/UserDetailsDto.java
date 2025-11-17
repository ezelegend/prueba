package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserDetailsDto {
    private Long userId;
    private String codUser;
    private String runUser;
    private String nameUser;
    private String ape1User;
    private String ape2User;
    private String email;
    private String configHSM;
    private String configHSMPDF;
    private String usuarioFirmante;

    private Long serviceId;
    private String serviceDescripcion;

    private boolean editItem;
    private boolean checkValidator;
    private boolean existData;

    private List<ProfileDto> perfilesAsociados;
    private List<ProfileDto> perfilesDisponibles;

    private List<MetodoFirmaDto> metodosFirmaAsociados;
    private List<MetodoFirmaDto> metodosFirmaDisponibles;

    private boolean verServicioFirma;
    private boolean verServicioVU;
    private boolean checkFirmante;

    private boolean flagTieneFirmaHSM;
    private Boolean claveFirmaRandom;

    private List<ServiceDto> contralorias;
    private Boolean habilitarAccesoEscritorio;

    private String calidadFirmante;
}