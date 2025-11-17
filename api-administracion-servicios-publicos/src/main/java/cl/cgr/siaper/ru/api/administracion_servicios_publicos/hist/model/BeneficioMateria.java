package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model;

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
@Table(name = "TRA_BENEFICIOS_MATERIAS")
public class BeneficioMateria implements java.io.Serializable{

	private static final long serialVersionUID = 7444428665168405774L;
	
	private Long id;
	private Materia materia;
	private Beneficio beneficio;
	private Date version;
	private String codUsuarioBloq;

	@Id
	@SequenceGenerator(allocationSize = 1, name = "generator", sequenceName = "TRA_S_BEMA_X_BEMA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "X_BEMA", unique = true, nullable = false, precision = 10, scale = 0)	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BENE_X_BENE", nullable = false)
	public Beneficio getBeneficio() {
		return beneficio;
	}
	public void setBeneficio(Beneficio beneficio) {
		this.beneficio = beneficio;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MATE_X_MATE", nullable = false)
	public Materia getMateria() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	@Column(name = "C_USUARIO_BLOQ", length = 50)
	public String getCodUsuarioBloq() {
		return this.codUsuarioBloq;
	}

	public void setCodUsuarioBloq(String codUsuarioBloq) {
		this.codUsuarioBloq = codUsuarioBloq;
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

	
	
	
	
	
	
	
}
