package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class SaveUserRequest {
    private Long userId;
    private String runUser;
    private String codUser;
    private String nameUser;
    private String ape1User;
    private String ape2User;
    private String email;
    private String configHSM;
    private String configHSMPDF;
    private String usuarioFirmante;
    private Long serviceId;
    private String calidadFirmante;
    private Boolean habilitarAccesoEscritorio;

    private Boolean checkFirmante;
    private Boolean verServicioVU;
    private Boolean flagTieneFirmaHSM;
    private Boolean claveFirmaRandom;

    private List<String> metodosFirma;

    public boolean isCheckFirmante() {
        return Boolean.TRUE.equals(this.checkFirmante);
    }

    public boolean isVerServicioVU() {
        return Boolean.TRUE.equals(this.verServicioVU);
    }
}