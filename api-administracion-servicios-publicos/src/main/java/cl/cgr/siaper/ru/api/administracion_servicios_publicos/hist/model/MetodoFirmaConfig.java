package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;

import org.hibernate.annotations.Type;

import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.converter.BooleanSiNoConverter;
/**
 * 
 * @author despinozan
 *
 */

@Entity
@Table(name = "TRA_METODOS_FIRMA_CONFIG")
public class MetodoFirmaConfig implements Serializable {

	private static final long serialVersionUID = -8504711509632338097L;

	private MetodoFirmaConfigPK metodoFirmaConfigPK;
	private String valor;
	private Date version;
	private Boolean activo;
	
	public MetodoFirmaConfig() { }

	public MetodoFirmaConfig(MetodoFirmaConfigPK metodoFirmaConfigPK, String valor, Date version) {
		this.metodoFirmaConfigPK = metodoFirmaConfigPK;
		this.valor = valor;
		this.version = version;
	}

	@EmbeddedId
//	@AttributeOverrides({ 
//		@AttributeOverride(name = "metodoFirma", column = @Column(name = "METO_X_METO")),
//		@AttributeOverride(name = "servicio", column = @Column(name = "SERV_X_SERV")),
//		@AttributeOverride(name = "metodoFirmaConfigAtributo", column = @Column(name = "MFCO_X_MFCO")) })
	public MetodoFirmaConfigPK getMetodoFirmaConfigPK() {
		return metodoFirmaConfigPK;
	}

	public void setMetodoFirmaConfigPK(MetodoFirmaConfigPK metodoFirmaConfigPK) {
		this.metodoFirmaConfigPK = metodoFirmaConfigPK;
	}

	@Column(name = "T_VALOR", nullable = false, length = 255)
	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@Version
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "F_VERSION", length = 7)
	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}
	@Column(name = "L_ACTIVO", length = 1)
	@Convert(converter = BooleanSiNoConverter.class)
	public Boolean getActivo() {
		return this.activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	@Override
	public String toString() {
		return "MetodoFirmaConfig [metodoFirmaConfigPK=" + metodoFirmaConfigPK + ", valor=" + valor + ", version="
				+ version + "]";
	}
}
