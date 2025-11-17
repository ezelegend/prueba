package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;

import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name = "TRA_NIVELES_EDUC_MINEDUC")
public class MineducNivelEducacional implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4566843328728617573L;
	
	private Long id;
	private Date version;
	private String descripcion;
	private String codUsuarioBloq;
	private NivelEducacional nivelEducacional;
	
	@Id
	@SequenceGenerator(allocationSize = 1, name = "generator", sequenceName = "TRA_S_NIEM_X_NIEM")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "X_NIEM", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "D_NIEM", length = 255)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NIED_X_NIED", nullable = false)
	public NivelEducacional getNivelEducacional() {
		return nivelEducacional;
	}

	public void setNivelEducacional(NivelEducacional nivelEducacional) {
		this.nivelEducacional = nivelEducacional;
	}
	
	@Version
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "F_VERSION", length = 7)
	public Date getVersion() {
		return this.version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}
	
	@Column(name = "C_USUARIO_BLOQ", length = 30)
	public String getCodUsuarioBloq() {
		return this.codUsuarioBloq;
	}

	public void setCodUsuarioBloq(String codUsuarioBloq) {
		this.codUsuarioBloq = codUsuarioBloq;
	}
}
