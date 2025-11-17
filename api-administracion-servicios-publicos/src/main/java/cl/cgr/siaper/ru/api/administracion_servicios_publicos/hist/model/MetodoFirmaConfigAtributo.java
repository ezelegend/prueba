package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model;

import static jakarta.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;

/**
 * 
 * @author despinozan
 *
 */

@Entity
@Table(name = "TRA_METODOS_FIRMA_CONFIG_ATTR")
public class MetodoFirmaConfigAtributo implements Serializable {

	private static final long serialVersionUID = -3226710692424617566L;

	private Long id;
	private String atributo;
	private String descripcion;
	private Date version;
	
	public MetodoFirmaConfigAtributo() { }

	public MetodoFirmaConfigAtributo(Long id, String atributo, String descripcion, Date version) {
		this.id = id;
		this.atributo = atributo;
		this.descripcion = descripcion;
		this.version = version;
	}

	@Id
	@SequenceGenerator(allocationSize = 1, name = "generator", sequenceName = "TRA_S_MFCO_X_MFCO")
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "X_MFCO", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "T_ATRIBUTO", unique = true, nullable = false, length = 255)
	public String getAtributo() {
		return atributo;
	}

	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}

	@Column(name = "T_DESCRIPCION", nullable = true, length = 255)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	@Override
	public String toString() {
		return "MetodoFirmaConfigAtributo [id=" + id + ", atributo=" + atributo + ", descripcion=" + descripcion
				+ ", version=" + version + "]";
	}
}
