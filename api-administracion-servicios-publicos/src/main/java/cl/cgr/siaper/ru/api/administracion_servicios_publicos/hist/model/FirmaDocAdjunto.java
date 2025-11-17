package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model;

import java.sql.Clob;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
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
@Table(name = "TRA_FIRMAS_DOC_ADJUNTOS")
public class FirmaDocAdjunto implements java.io.Serializable {

	private static final long serialVersionUID = -3683451030023218402L;
	
	private Long id;
	private FirmaDoc firmaDoc;
	private String hashDocu;
	private String hashDocuAlgoritmo;
	private Clob contenidoAFirmar;
	private Clob hashFirma;
	private Clob docuFirmado;
	private Date version;
	private String codUsuarioBloq;

	public FirmaDocAdjunto() {}

	@Id
	@SequenceGenerator(allocationSize = 1, name = "generator", sequenceName = "TRA_S_FIDA_X_FIDA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "X_FIDA", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FIDO_X_FIDO")
	public FirmaDoc getFirmaDoc() {
		return firmaDoc;
	}

	public void setFirmaDoc(FirmaDoc firmaDoc) {
		this.firmaDoc = firmaDoc;
	}

	@Column(name = "T_HASH_DOCU", length = 250, nullable = true)
	public String getHashDocu() {
		return hashDocu;
	}

	public void setHashDocu(String hashDocu) {
		this.hashDocu = hashDocu;
	}

	@Column(name = "T_HASH_DOCU_ALG", length = 250, nullable = true)
	public String getHashDocuAlgoritmo() {
		return hashDocuAlgoritmo;
	}

	public void setHashDocuAlgoritmo(String hashDocuAlgoritmo) {
		this.hashDocuAlgoritmo = hashDocuAlgoritmo;
	}

	@Column(name = "T_CONTENIDO_FIRMAR", nullable = true)
	public Clob getContenidoAFirmar() {
		return contenidoAFirmar;
	}

	public void setContenidoAFirmar(Clob contenidoAFirmar) {
		this.contenidoAFirmar = contenidoAFirmar;
	}

	@Column(name = "T_HASH_FIRMA", nullable = true)
	public Clob getHashFirma() {
		return hashFirma;
	}

	public void setHashFirma(Clob hashFirma) {
		this.hashFirma = hashFirma;
	}

	@Column(name = "T_DOC_FIRMADO", nullable = true)
	public Clob getDocuFirmado() {
		return docuFirmado;
	}

	public void setDocuFirmado(Clob docuFirmado) {
		this.docuFirmado = docuFirmado;
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof FirmaDocAdjunto))
			return false;
		FirmaDocAdjunto castOther = (FirmaDocAdjunto) other;
		return this.getId() != null && castOther.getId() != null && this.getId().equals(castOther.getId());
	}

	@Override
	public String toString() {
		return "FirmaDocAdjunto [id=" + id + ", firmaDoc=" + firmaDoc + ", hashDocu=" + hashDocu
				+ ", hashDocuAlgoritmo=" + hashDocuAlgoritmo + ", contenidoAFirmar=" + contenidoAFirmar + ", hashFirma="
				+ hashFirma + ", docuFirmado=" + docuFirmado + ", version=" + version + ", codUsuarioBloq="
				+ codUsuarioBloq + "]";
	}
}