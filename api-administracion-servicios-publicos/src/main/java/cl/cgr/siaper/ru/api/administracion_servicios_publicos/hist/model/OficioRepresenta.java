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
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;

import org.hibernate.envers.Audited;


@Entity
@Audited
@Table(name = "TRA_OFICIO_REPRESENTA")
public class OficioRepresenta implements Serializable, Cloneable {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = -917591085514711417L;
	private Long id;
	private Integer numOficio;
	private short anioOficio;
	private Date fechaEmision;
	private Date version;
	private Documento documento;
	private String nroOficio;
	private String prefijo;

	public OficioRepresenta() {
	}

	@Id
	@SequenceGenerator(allocationSize = 1, name = "generator", sequenceName = "TRA_S_OFRE_X_OFRE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "X_OFRE", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "N_OFICIO", precision = 10)
	public Integer getNumOficio() {
		return numOficio;
	}

	public void setNumOficio(Integer numOficio) {
		this.numOficio = numOficio;
	}

	@Column(name = "N_ANIO_OFICIO", precision = 4)
	public short getAnioOficio() {
		return anioOficio;
	}

	public void setAnioOficio(short anioOficio) {
		this.anioOficio = anioOficio;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "F_EMISION", length = 7)
	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
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
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOCU_X_DOCU", nullable = false)
	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}
	
	@Column(name = "T_N_OFICIO  ", length = 255)
	public String getNroOficio() {
		return this.nroOficio;
	}

	public void setNroOficio(String nroOficio) {
		this.nroOficio = nroOficio;
	}
	
	@Column(name = "C_PREFIJO ", length = 10)
	public String getPrefijo() {
		return this.prefijo;
	}

	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}
	
	
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OficioRepresenta))
			return false;
		OficioRepresenta castOther = (OficioRepresenta) other;
		return this.getId() != null && castOther.getId() != null && this.getId().equals(castOther.getId());
	}
	
}
