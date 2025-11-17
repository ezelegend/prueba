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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;

import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name = "TRA_FIRMAS_TRA")
public class Firmas implements java.io.Serializable {

	private static final long serialVersionUID = 3282999561830916591L;

	private Long id;
	private String firmante;
	private String codTransaccion;
	private Date fechaFirma;
	private Fichero ficheroPDF;
	private Fichero ficheroXML;
	private Documento documento;
	private String tipoDocFirmado;
	private Date version;
	private String codUsuarioBloq;
	private String csvFirma;

	public Firmas() {
	}

	@Id
	@SequenceGenerator(allocationSize = 1, name = "generator", sequenceName = "TRA_S_FITR_X_FITR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "X_FITR", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Column(name = "C_USUARIO_BLOQ", length = 50)
	public String getCodUsuarioBloq() {
		return this.codUsuarioBloq;
	}

	public void setCodUsuarioBloq(String codUsuarioBloq) {
		this.codUsuarioBloq = codUsuarioBloq;
	}


	@Column(name = "T_FIRMANTE", length = 255)
	public String getFirmante() {
		return firmante;
	}

	public void setFirmante(String firmante) {
		this.firmante = firmante;
	}

	
	@Column(name = "C_TRANSACCION", length = 250)
	public String getCodTransaccion() {
		return codTransaccion;
	}

	public void setCodTransaccion(String codTransaccion) {
		this.codTransaccion = codTransaccion;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "F_FIRMA", length = 7)
	public Date getFechaFirma() {
		return fechaFirma;
	}

	public void setFechaFirma(Date fechaFirma) {
		this.fechaFirma = fechaFirma;
	}

	@Column(name = "V_TIPO_DOC_FIRM", length = 1)
	public String getTipoDocFirmado() {
		return tipoDocFirmado;
	}
	
	public void setTipoDocFirmado(String tipoDocFirmado) {
		this.tipoDocFirmado = tipoDocFirmado;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FICH_X_FICH_PDF", nullable = true)
	public Fichero getFicheroPDF() {
		return ficheroPDF;
	}

	public void setFicheroPDF(Fichero ficheroPDF) {
		this.ficheroPDF = ficheroPDF;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FICH_X_FICH_XML", nullable = true)
	public Fichero getFicheroXML() {
		return ficheroXML;
	}

	public void setFicheroXML(Fichero ficheroXML) {
		this.ficheroXML = ficheroXML;
	}
	
	/**
	 * @return the csvFirma
	 */
	@Column(name = "C_CSV", length = 50)
	public String getCsvFirma() {
		return csvFirma;
	}

	/**
	 * @param csvFirma the csvFirma to set
	 */
	public void setCsvFirma(String csvFirma) {
		this.csvFirma = csvFirma;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOCU_X_DOCU", nullable = false)
	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Firmas))
			return false;
		Firmas castOther = (Firmas) other;
		return this.getId() != null && castOther.getId() != null && this.getId().equals(castOther.getId());
	}

}
