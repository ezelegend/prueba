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
import jakarta.persistence.Transient;
import jakarta.persistence.Version;

import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name = "TRA_ERROR_SERV_WEB")
public class ErrorServicioWeb implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -823747211988652823L;
	
	private Long id;
	private Date version;
	private String codUsuarioBloq;
	private Date fecha;
	private String msgError;
	private CasoDocumento casoDocumento;
	private ServicioWeb servicioWeb;
	
	private String invocacionWS;
	
	public ErrorServicioWeb() {
		
	}

	@Id
	@SequenceGenerator(allocationSize = 1, name = "generator", sequenceName = "TRA_S_ERSW_X_ERSW")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "X_ERSW", unique = true, nullable = false, precision = 10, scale = 0)
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

	@ManyToOne
	@JoinColumn(name = "SEWE_X_SEWE", nullable = false)
	public ServicioWeb getServicioWeb() {
		return servicioWeb;
	}

	public void setServicioWeb(ServicioWeb servicioWeb) {
		this.servicioWeb = servicioWeb;
	}
	
	@Transient
	public String getInvocacionWS() {
		return invocacionWS;
	}

	public void setInvocacionWS(String invocacionWS) {
		this.invocacionWS = invocacionWS;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ErrorServicioWeb))
			return false;
		ErrorServicioWeb castOther = (ErrorServicioWeb) other;
		return this.getId() != null && castOther.getId() != null && this.getId().equals(castOther.getId());
	}

}
