package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model;

import java.util.*;

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
import jakarta.persistence.UniqueConstraint;

import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name = "TRA_FUNCIONARIO_PECUN", uniqueConstraints = @UniqueConstraint(columnNames = "X_FPECU"))
public class FuncionarioPecuniario implements java.io.Serializable {

	private static final long serialVersionUID = -7904829046866790396L;
	
	private Long id;
	private String run;
	private String nombreCompleto;
	private String docDesc;
	private String urlArchivo;
	private String docServicio;
	private Long idCPecu;
	private Date fechaDocServ;
	private String glosa1;
	private String pecuDesc;
	private Long montoDeuda;
	private String glosa2;
	private String docEstudioDesc;
	private String registroDesc;
	private Long idDoc;
	private String estado;
	private Long servicioId;
	
	public FuncionarioPecuniario() {
		
	}
	
	@Id
	@SequenceGenerator(allocationSize = 1, name = "generator", sequenceName = "TRA_S_FPECU_X_FPECU")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "X_FPECU", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "T_RUN", length = 10)
	public String getRun() {
		return run;
	}
	
	public void setRun(String run) {
		this.run = run;
	}
	
	@Column(name = "T_NOMBRE_COMPLETO", length = 200)
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	
	@Column(name = "T_DOC_DESCR", length = 255)
	public String getDocDesc() {
		return docDesc;
	}
	
	public void setDocDesc(String docDesc) {
		this.docDesc = docDesc;
	}
	
	@Column(name = "T_URL_ARCHIVO", length = 255)
	public String getUrlArchivo() {
		return urlArchivo;
	}
	
	public void setUrlArchivo(String urlArchivo) {
		this.urlArchivo = urlArchivo;
	}
	
	@Column(name = "N_DOC_SERVICIO", length = 255)
	public String getDocServicio() {
		return docServicio;
	}
	
	public void setDocServicio(String docServicio) {
		this.docServicio = docServicio;
	}
	
	@Column(name = "P_ID_CPECU", unique = true, nullable = false, length = 12)
	public Long getIdCPecu() {
		return idCPecu;
	}
	
	public void setIdCPecu(Long idCPecu) {
		this.idCPecu = idCPecu;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "F_DOC_SERVICIO", length = 7)
	public Date getFechaDocServ() {
		return fechaDocServ;
	}
	
	public void setFechaDocServ(Date fechaDocServ) {
		this.fechaDocServ = fechaDocServ;
	}
	
	@Column(name = "S_GLOSA1", length = 255)
	public String getGlosa1() {
		return glosa1;
	}
	
	public void setGlosa1(String glosa1) {
		this.glosa1 = glosa1;
	}
	
	@Column(name = "M_CPECU_DESCR", length = 255)
	public String getPecuDesc() {
		return pecuDesc;
	}
	
	public void setPecuDesc(String pecuDesc) {
		this.pecuDesc = pecuDesc;
	}
	
	@Column(name = "P_MONTO_DEUDA", length = 12)
	public Long getMontoDeuda() {
		return montoDeuda;
	}
	
	public void setMontoDeuda(Long montoDeuda) {
		this.montoDeuda = montoDeuda;
	}
	
	@Column(name = "S_GLOSA2", length = 255)
	public String getGlosa2() {
		return glosa2;
	}
	
	public void setGlosa2(String glosa2) {
		this.glosa2 = glosa2;
	}
	
	@Column(name = "E_DOC_ESTUDIO_DESCR", length = 255)
	public String getDocEstudioDesc() {
		return docEstudioDesc;
	}
	
	public void setDocEstudioDesc(String docEstudioDesc) {
		this.docEstudioDesc = docEstudioDesc;
	}
	
	@Column(name = "E_REGISTRO_DESCR", length = 255)
	public String getRegistroDesc() {
		return registroDesc;
	}
	
	public void setRegistroDesc(String registroDesc) {
		this.registroDesc = registroDesc;
	}
	
	@Column(name = "P_ID_DOC", length = 10)
	public Long getIdDoc() {
		return idDoc;
	}
	
	public void setIdDoc(Long idDoc) {
		this.idDoc = idDoc;
	}
	
	@Column(name = "T_ESTADO", length = 1)
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@Column(name = "SERV_X_SERV", length = 10)
	public Long getServicioId() {
		return servicioId;
	}
	
	public void setServicioId(Long servicioId) {
		this.servicioId = servicioId;
	}
	
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof FuncionarioPecuniario))
			return false;
		FuncionarioPecuniario castOther = (FuncionarioPecuniario) other;
		return this.getId() != null && castOther.getId() != null && this.getId().equals(castOther.getId());
	}
}
