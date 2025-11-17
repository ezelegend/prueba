package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "TRA_FIRMANTES_X_CONFIG")
public class FirmanteCgrConfig implements java.io.Serializable {
	
	private static final long serialVersionUID = 1650864491193475435L;

	private Long id;
	private FirmanteCgr firmanteCgr;
	private Servicio servicioFirmante;
	private TipoDocumento tipoDocumento;
	private Materia materia;
	private Date version;
	private Boolean activo;
	
	public FirmanteCgrConfig() {
	}
	
	@SequenceGenerator(allocationSize = 1, name = "generator", sequenceName = "TRA_S_FIRM_X_CONFIG")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "X_FIRMCGR", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FIRM_X_FIRM", nullable = false)
	public FirmanteCgr getFirmanteCgr() {
		return firmanteCgr;
	}
	
	public void setFirmanteCgr(FirmanteCgr firmanteCgr) {
		this.firmanteCgr = firmanteCgr;
	}
		
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SERV_X_SERV", nullable = false)
	public Servicio getServicioFirmante() {
		return servicioFirmante;
	}
	
	public void setServicioFirmante(Servicio servicioFirmante) {
		this.servicioFirmante = servicioFirmante;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIP_X_DOC", nullable = false)
	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}
	
	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MATE_X_MATE", nullable = false)
	public Materia getMateria() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
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
}
