package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model;

import java.io.Serializable;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

import org.hibernate.annotations.Type;

import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.converter.BooleanSiNoConverter;

/**
 * 
 * @author despinozan
 *
 */

@Entity
@Table(name = "TRA_METODOS_FIRMA_RELACION")
public class MetodoFirmaRelacion implements Serializable{

	private static final long serialVersionUID = -6452647721513429227L;
	
	private MetodoFirmaRelacionPK metodoFirmaRelacionPK;
	private boolean claveAleatoria;
	private boolean firmaUnica;
	private Usuario usuario;
	private Servicio servicio;
	private MetodoFirma metodoFirma;
	
	public MetodoFirmaRelacion(){}
	

	public MetodoFirmaRelacion(MetodoFirmaRelacionPK metodoFirmaRelacionPK, boolean claveAleatoria, boolean firmaUnica,
			Usuario usuario, Servicio servicio, MetodoFirma metodoFirma) {
		this.metodoFirmaRelacionPK = metodoFirmaRelacionPK;
		this.claveAleatoria = claveAleatoria;
		this.firmaUnica = firmaUnica;
		this.usuario = usuario;
		this.servicio = servicio;
		this.metodoFirma = metodoFirma;
	}


	@EmbeddedId
	@AttributeOverrides({ 
		@AttributeOverride(name = "usuarioId", column = @Column(name = "USUA_X_USUA")),
		@AttributeOverride(name = "servicioId", column = @Column(name = "SERV_X_SERV")),
		@AttributeOverride(name = "metodoFirmaId", column = @Column(name = "METO_X_METO")) })
	public MetodoFirmaRelacionPK getMetodoFirmaRelacionPK() {
		return metodoFirmaRelacionPK;
	}

	public void setMetodoFirmaRelacionPK(MetodoFirmaRelacionPK metodoFirmaRelacionPK) {
		this.metodoFirmaRelacionPK = metodoFirmaRelacionPK;
	}

	@Column(name = "L_CLAVE_ALEATORIA", length = 1)
	@Convert(converter = BooleanSiNoConverter.class)
	public boolean isClaveAleatoria() {
		return claveAleatoria;
	}

	public void setClaveAleatoria(boolean claveAleatoria) {
		this.claveAleatoria = claveAleatoria;
	}

	@Column(name = "L_FIRMA_UNICA", length = 1)
	@Convert(converter = BooleanSiNoConverter.class)
	public boolean isFirmaUnica() {
		return firmaUnica;
	}

	public void setFirmaUnica(boolean firmaUnica) {
		this.firmaUnica = firmaUnica;
	}

	@MapsId("usuarioId")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUA_X_USUA", nullable = false)
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@MapsId("servicioId")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SERV_X_SERV", nullable = false)
	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	@MapsId("metodoFirmaId")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "METO_X_METO", nullable = false)
	public MetodoFirma getMetodoFirma() {
		return metodoFirma;
	}

	public void setMetodoFirma(MetodoFirma metodoFirma) {
		this.metodoFirma = metodoFirma;
	}

	@Override
	public String toString() {
		return "MetodoFirmaRelacion [metodoFirmaRelacionPK=" + metodoFirmaRelacionPK + ", claveAleatoria="
				+ claveAleatoria + ", firmaUnica=" + firmaUnica + "]";
	}
}