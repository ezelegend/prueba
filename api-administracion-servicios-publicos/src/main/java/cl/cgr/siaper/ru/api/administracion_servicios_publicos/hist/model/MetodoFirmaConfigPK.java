package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * 
 * @author despinozan
 *
 */

@Embeddable
public class MetodoFirmaConfigPK implements Serializable {

	private static final long serialVersionUID = 1831434470468314246L;

	private MetodoFirma metodoFirma;
	private Servicio servicio;
	private MetodoFirmaConfigAtributo metodoFirmaConfigAtributo;
	
	public MetodoFirmaConfigPK() {}

	public MetodoFirmaConfigPK(MetodoFirma metodoFirma, Servicio servicio,
			MetodoFirmaConfigAtributo metodoFirmaConfigAtributo) {
		this.metodoFirma = metodoFirma;
		this.servicio = servicio;
		this.metodoFirmaConfigAtributo = metodoFirmaConfigAtributo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "METO_X_METO", nullable = false)
	public MetodoFirma getMetodoFirma() {
		return metodoFirma;
	}

	public void setMetodoFirma(MetodoFirma metodoFirma) {
		this.metodoFirma = metodoFirma;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SERV_X_SERV", nullable = false)
	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MFCO_X_MFCO", nullable = false)
	public MetodoFirmaConfigAtributo getMetodoFirmaConfigAtributo() {
		return metodoFirmaConfigAtributo;
	}

	public void setMetodoFirmaConfigAtributo(MetodoFirmaConfigAtributo metodoFirmaConfigAtributo) {
		this.metodoFirmaConfigAtributo = metodoFirmaConfigAtributo;
	}

	@Override
	public String toString() {
		return "MetodoFirmaConfigPK [metodoFirma=" + metodoFirma + ", servicio=" + servicio
				+ ", metodoFirmaConfigAtributo=" + metodoFirmaConfigAtributo + "]";
	}
}
