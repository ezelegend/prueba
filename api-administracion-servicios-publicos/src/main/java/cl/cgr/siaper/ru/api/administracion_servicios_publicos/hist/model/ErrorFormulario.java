package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
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

import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name = "TRA_ERROR_FORMULARIO")
public class ErrorFormulario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4080434497020731895L;
	
	private Long id;
	private Date version;
	private String codUsuarioBloq;
	private String atributo;
	private String label;
	private String pagina;
	private String identificadorPagina;
	private Date fecha;
	private String msgError;
	private CasoDocumento casoDocumento;
	
	public ErrorFormulario() {
		
	}

	@Id
	@SequenceGenerator(allocationSize = 1, name = "generator", sequenceName = "TRA_S_ERFO_X_ERFO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "X_ERFO", unique = true, nullable = false)
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

	@Column(name = "T_ATRIBUTO", length = 256, nullable = false)
	public String getAtributo() {
		return atributo;
	}

	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}

	@Column(name = "T_LABEL", length = 3000)
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	@Column(name = "T_PAGINA", length = 256)
	public String getPagina() {
		return pagina;
	}

	public void setPagina(String pagina) {
		this.pagina = pagina;
	}
	
	@Column(name = "T_PAGINA_IDENTIFICADOR", length = 256)
	public String getIdentificadorPagina() {
		return identificadorPagina;
	}

	public void setIdentificadorPagina(String identificadorPagina) {
		this.identificadorPagina = identificadorPagina;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "F_FECHA", length = 7, nullable = false)
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Column(name = "T_MSG_ERROR", length = 150)
	public String getMsgError() {
		return msgError;
	}

	public void setMsgError(String msgError) {
		this.msgError = msgError;
	}

	@ManyToOne
	@JoinColumn(name = "CADO_X_CADO", nullable = false)
	public CasoDocumento getCasoDocumento() {
		return casoDocumento;
	}

	public void setCasoDocumento(CasoDocumento casoDocumento) {
		this.casoDocumento = casoDocumento;
	}
	
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ErrorFormulario))
			return false;
		ErrorFormulario castOther = (ErrorFormulario) other;
		return this.getId() != null && castOther.getId() != null && this.getId().equals(castOther.getId());
	}

}
