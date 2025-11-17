package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
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

import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;

import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.converter.BooleanSiNoConverter;

@Entity
@Audited
@Table(name = "TRA_REQART_CAMINO_TRA_ESP")
public class ReqartCaminoTraEsp implements Serializable, Comparable<ReqartCaminoTraEsp> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8520460306851745043L;

	private Long id;
	private Date version;
	private String codUsuarioBloq;
	private CaminoTraEsp caminoTraEsp;
	private RequisitoArticulo requisitoArticulo;
	private Boolean alternativa;
	private long numOrden;
	
	public ReqartCaminoTraEsp() {
		
	}

	@SequenceGenerator(allocationSize = 1, name = "generator", sequenceName = "TRA_S_RCTE_X_RCTE")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "X_RCTE", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Column(name = "C_USUARIO_BLOQ", length = 50)
	public String getCodUsuarioBloq() {
		return codUsuarioBloq;
	}

	public void setCodUsuarioBloq(String codUsuarioBloq) {
		this.codUsuarioBloq = codUsuarioBloq;
	}

	@ManyToOne
	@JoinColumn(name = "CTRE_X_CTRE", nullable = false)
	public CaminoTraEsp getCaminoTraEsp() {
		return caminoTraEsp;
	}

	public void setCaminoTraEsp(CaminoTraEsp caminoTraEsp) {
		this.caminoTraEsp = caminoTraEsp;
	}

	@ManyToOne
	@JoinColumn(name = "REAR_X_REAR", nullable = false)
	public RequisitoArticulo getRequisitoArticulo() {
		return requisitoArticulo;
	}

	public void setRequisitoArticulo(RequisitoArticulo requisitoArticulo) {
		this.requisitoArticulo = requisitoArticulo;
	}

	@Column(name = "L_ALTERNATIVA", length = 1, nullable = false)
	@Convert(converter = BooleanSiNoConverter.class)
	public Boolean getAlternativa() {
		return alternativa;
	}

	public void setAlternativa(Boolean alternativa) {
		this.alternativa = alternativa;
	}

	@Column(name = "N_ORDEN", nullable = false, precision = 10, scale = 0)
	public long getNumOrden() {
		return numOrden;
	}

	public void setNumOrden(long numOrden) {
		this.numOrden = numOrden;
	}
	public int compareTo(ReqartCaminoTraEsp rc) {
		return (int) (this.numOrden - rc.numOrden);
	}
	
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ReqartCaminoTraEsp))
			return false;
		ReqartCaminoTraEsp castOther = (ReqartCaminoTraEsp) other;
		return this.getId() != null && castOther.getId() != null && this.getId().equals(castOther.getId());
	}
}
