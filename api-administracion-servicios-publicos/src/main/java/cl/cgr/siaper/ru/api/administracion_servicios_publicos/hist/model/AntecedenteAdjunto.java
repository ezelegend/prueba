package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model;

import java.util.Date;

import jakarta.persistence.CascadeType;
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
import jakarta.persistence.Transient;
import jakarta.persistence.Version;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

@Entity
@Audited
@AuditTable("TRA_ANTECEDENTES_ADJUNTOS_HIST")
@Table(name = "TRA_ANTECEDENTES_ADJUNTOS")
public class AntecedenteAdjunto implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7479111131937277236L;
	
	
	private Long id;
	private String observaciones;
	private Fichero fichero;
	private CasoDocumento casoDocumento;
	private Date version;
	
	/**
	 * Atributo Transient
	 * Indica si el fichero está en el CM
	 * @author despinozan
	 */
	private boolean existeFichero;
	
	
	@Id
	@SequenceGenerator(allocationSize = 1, name = "generator", sequenceName = "TRA_S_ANAD_X_ANAD")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "X_ANAD", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "T_OBSERVACIONES", length = 500)
	public String getObservaciones() {
		return observaciones;
	}
	
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "FICH_X_FICH")
	public Fichero getFichero() {
		return fichero;
	}
	
	public void setFichero(Fichero fichero) {
		this.fichero = fichero;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CADO_X_CADO", nullable = false)
	public CasoDocumento getCasoDocumento() {
		return casoDocumento;
	}
	
	public void setCasoDocumento(CasoDocumento casoDocumento) {
		this.casoDocumento = casoDocumento;
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
	
	@Transient
	public boolean getExisteFichero() {
		return existeFichero;
	}

	public void setExisteFichero(boolean existeFichero) {
		this.existeFichero = existeFichero;
	}
	
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AntecedenteAdjunto))
			return false;
		AntecedenteAdjunto castOther = (AntecedenteAdjunto) other;
		return this.getId() != null && castOther.getId() != null && this.getId().equals(castOther.getId());
	}
	
}
