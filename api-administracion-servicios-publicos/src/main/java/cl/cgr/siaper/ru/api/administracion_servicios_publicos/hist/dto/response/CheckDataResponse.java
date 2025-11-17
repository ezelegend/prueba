package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.dto.response;

import lombok.Data;

@Data
public class CheckDataResponse {
    private String status;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String email;
    private String message;

    public static CheckDataResponse found(String nombres, String ap1, String ap2, String email) {
        CheckDataResponse r = new CheckDataResponse();
        r.status = "FOUND";
        r.nombres = nombres;
        r.apellidoPaterno = ap1;
        r.apellidoMaterno = ap2;
        r.email = email;
        return r;
    }

    public static CheckDataResponse notFound(String msg) {
        CheckDataResponse r = new CheckDataResponse();
        r.status = "NOT_FOUND";
        r.message = msg;
        return r;
    }

    public static CheckDataResponse error(String msg) {
        CheckDataResponse r = new CheckDataResponse();
        r.status = "ERROR";
        r.message = msg;
        return r;
    }
}