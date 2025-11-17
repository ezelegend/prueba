package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
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

import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;

import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.converter.BooleanSiNoConverter;

@Entity
@Audited
@Table(name = "TRA_FIRMANTES_CGR")
public class FirmanteCgr implements java.io.Serializable {
	
	private static final long serialVersionUID = 1650864491193475435L;

	private Long id;
	private Usuario usuarioFirmanteCgr;
	private Servicio servicioFirmante;
	private Long calidadFirmante;
	private Date version;
	private Boolean activo;
	private RuUsuario ruUsuario;  // FK to RU_USUARIOS for dual-write strategy
	
	public FirmanteCgr() {
	}
	
	@SequenceGenerator(allocationSize = 1, name = "generator", sequenceName = "TRA_S_FIRM_X_FIRM")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "X_FIRM", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUA_X_USUA", nullable = false)
	public Usuario getUsuarioFirmanteCgr() {
		return usuarioFirmanteCgr;
	}
	
	public void setUsuarioFirmanteCgr(Usuario usuarioFirmanteCgr) {
		this.usuarioFirmanteCgr = usuarioFirmanteCgr;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SERV_X_SERV", nullable = false)
	public Servicio getServicioFirmante() {
		return servicioFirmante;
	}
	
	public void setServicioFirmante(Servicio servicioFirmante) {
		this.servicioFirmante = servicioFirmante;
	}
	
	@Column(name = "TIT_X_SUB", nullable = false, length = 1)
	public Long getCalidadFirmante() {
		return calidadFirmante;
	}
	public void setCalidadFirmante(Long calidadFirmante) {
		this.calidadFirmante = calidadFirmante;
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
	
	@Column(name = "L_ACTIVO", nullable = false, length = 1)
	@Convert(converter = BooleanSiNoConverter.class)
	public Boolean getActivo() {
		return activo;
	}
	
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUA_RU_X_USUA")
	public RuUsuario getRuUsuario() {
		return ruUsuario;
	}
	
	public void setRuUsuario(RuUsuario ruUsuario) {
		this.ruUsuario = ruUsuario;
	}
}
