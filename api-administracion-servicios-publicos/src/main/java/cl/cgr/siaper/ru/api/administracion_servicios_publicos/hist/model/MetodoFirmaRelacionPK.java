package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

/**
 * 
 * @author despinozan
 *
 */

@Embeddable
public class MetodoFirmaRelacionPK implements Serializable {

	private static final long serialVersionUID = 2821726517471062672L;
	
	private Long usuarioId;
	private Long servicioId;
	private Long metodoFirmaId;

	public MetodoFirmaRelacionPK() {}

	public MetodoFirmaRelacionPK(Long usuarioId, Long servicioId, Long metodoFirmaId) {
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
		return "MetodoFirmaRelacionPK [usuarioId=" + usuarioId + ", servicioId=" + servicioId + ", metodoFirmaId=" + metodoFirmaId
				+ "]";
	}
}