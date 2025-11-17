package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model;

import static jakarta.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Version;

import org.hibernate.annotations.Type;

import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.converter.BooleanSiNoConverter;

/**
 * 
 * @author despinozan
 *
 */

@Entity
@Table(name = "TRA_METODOS_FIRMA", uniqueConstraints = @UniqueConstraint(columnNames = "C_METODO"))
public class MetodoFirma implements Serializable {
	
	private static final long serialVersionUID = -4763310982891938292L;
	
	private Long id;
	private String codigo;
	private String descripcion;
	private Boolean activo;
	private Date version;
	
	public MetodoFirma() {
	}

	@Id
	@SequenceGenerator(allocationSize = 1, name = "generator", sequenceName = "TRA_S_METO_X_METO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "X_METO", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "C_METODO", unique = true, nullable = false, length = 150)
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Column(name = "T_DESCRIPCION", nullable = true, length = 150)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "L_ACTIVO", nullable = false, length = 1)
	@Convert(converter = BooleanSiNoConverter.class)
	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
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
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MetodoFirma))
			return false;
		MetodoFirma castOther = (MetodoFirma) other;
		return this.getId() != null && castOther.getId() != null && this.getId().equals(castOther.getId());
	}

	@Override
	public String toString() {
		return "MetodoFirma [id=" + id + ", codigo=" + codigo + ", descripcion=" + descripcion + ", activo=" + activo
				+ ", version=" + version + "]";
	}
}
