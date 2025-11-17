package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model;

import java.io.Serializable;
import jakarta.persistence.Embeddable;

/**
 * Composite primary key for RuMetodoFirmaRelacion entity.
 */
@Embeddable
public class RuMetodoFirmaRelacionPK implements Serializable {

    private static final long serialVersionUID = 2821726517471062673L;

    private Long usuarioId;
    private Long servicioId;
    private Long metodoFirmaId;

    public RuMetodoFirmaRelacionPK() {}

    public RuMetodoFirmaRelacionPK(Long usuarioId, Long servicioId, Long metodoFirmaId) {
        this.usuarioId = usuarioId;
        this.servicioId = servicioId;
        this.metodoFirmaId = metodoFirmaId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getServicioId() {
        return servicioId;
    }

    public void setServicioId(Long servicioId) {
        this.servicioId = servicioId;
    }

    public Long getMetodoFirmaId() {
        return metodoFirmaId;
    }

    public void setMetodoFirmaId(Long metodoFirmaId) {
        this.metodoFirmaId = metodoFirmaId;
    }

    @Override
    public String toString() {
        return "RuMetodoFirmaRelacionPK [usuarioId=" + usuarioId + ", servicioId=" + servicioId + ", metodoFirmaId=" + metodoFirmaId + "]";
    }
}
