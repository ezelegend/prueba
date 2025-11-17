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

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

@Entity
@Audited
@AuditTable("TRA_CARGA_WS_HIST")
@Table(name = "TRA_CARGA_WS")
public class CargaServiciosWeb implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7479111131937277236L;
	
	
	private Long id;
	private CargaFormulario cargaFormulario;
	private Date version;
	private Long tiempoCarga;
	private Long numeroWs;
	
	@Id
	@SequenceGenerator(allocationSize = 1, name = "generator", sequenceName = "TRA_S_CAWS_X_CAWS")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "X_CAWS", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return the cargaFormulario
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CAFO_X_CAFO", nullable = false)
	public CargaFormulario getCargaFormulario() {
		return cargaFormulario;
	}

	/**
	 * @param cargaFormulario the cargaFormulario to set
	 */
	public void setCargaFormulario(CargaFormulario cargaFormulario) {
		this.cargaFormulario = cargaFormulario;
	}

	/**
	 * @return the tiempoCarga
	 */
	@Column(name = "N_TIEMPO_CARGA")
	public Long getTiempoCarga() {
		return tiempoCarga;
	}

	/**
	 * @param tiempoCarga the tiempoCarga to set
	 */
	public void setTiempoCarga(Long tiempoCarga) {
		this.tiempoCarga = tiempoCarga;
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
	
	/**
	 * @return the numeroHechos
	 */
	@Column(name = "N_WS")
	public Long getNumeroWs() {
		return numeroWs;
	}

	/**
	 * @param numeroHechos the numeroHechos to set
	 */
	public void setNumeroWs(Long numeroWs) {
		this.numeroWs = numeroWs;
	}
	
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CargaServiciosWeb))
			return false;
		CargaServiciosWeb castOther = (CargaServiciosWeb) other;
		return this.getId() != null && castOther.getId() != null && this.getId().equals(castOther.getId());
	}
	
}
