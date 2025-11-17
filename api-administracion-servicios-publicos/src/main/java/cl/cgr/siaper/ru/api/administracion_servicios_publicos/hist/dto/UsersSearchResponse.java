package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UsersSearchResponse {
    private List<UserSummary> active;
    private List<UserSummary> inactive;

    @Data
    @Builder
    public static class UserSummary {
        private Long id;
        private String codigo;
        private String run;
        private String nombre;
        private String apellido1;
        private String apellido2;
        private String servicio;
        private boolean activo;
    }
}