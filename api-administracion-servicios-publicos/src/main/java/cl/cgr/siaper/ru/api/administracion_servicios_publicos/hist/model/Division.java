//TODO: quedo con TRA
package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
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
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Version;

import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;

import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.converter.BooleanSiNoConverter;

@Entity
@Audited
@Table(name = "TRA_DIVISIONES", uniqueConstraints = @UniqueConstraint(columnNames = "C_DIVI"))
public class Division implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4267029136541390105L;

	private Long id;
	private Date version;
	private String codigo;
	private String descripcion;
	private boolean activo;
	private String codUsuarioBloq;
	private Region region;
	private Servicio servicio;
	private String descriptorEmisorTramitacion;
	
	private Set<UsuarioDivision> usuariosDivision = new HashSet<UsuarioDivision>(0);
	private Set<Documento> documentos = new HashSet<Documento>(0);
	
	public Division() {
		
	}

	@Id
	@SequenceGenerator(allocationSize = 1, name = "generator", sequenceName = "TRA_S_DIVI_X_DIVI")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "X_DIVI", unique = true, nullable = false, precision = 10, scale = 0)
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

	@Column(name = "C_DIVI", unique = true, nullable = false, length = 20)
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Column(name = "D_DIVI", nullable = false, length = 250)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "L_ACTIVO", nullable = false, length = 1)
	@Convert(converter = BooleanSiNoConverter.class)
	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Column(name = "C_USUARIO_BLOQ", length = 50)
	public String getCodUsuarioBloq() {
		return codUsuarioBloq;
	}

	public void setCodUsuarioBloq(String codUsuarioBloq) {
		this.codUsuarioBloq = codUsuarioBloq;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "division")
	public Set<UsuarioDivision> getUsuariosDivision() {
		return usuariosDivision;
	}

	public void setUsuariosDivision(Set<UsuarioDivision> usuariosDivision) {
		this.usuariosDivision = usuariosDivision;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "division")
	public Set<Documento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(Set<Documento> documentos) {
		this.documentos = documentos;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REGI_X_REGI")
	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SERV_X_SERV")
	public Servicio getServicio() {
	    return servicio;
	}

	public void setServicio(Servicio servicio) {
	    this.servicio = servicio;
	}
	
	@Column(name = "D_EMISOR_TRAMITACION", length = 250)
	public String getDescriptorEmisorTramitacion() {
		return descriptorEmisorTramitacion;
	}

	public void setDescriptorEmisorTramitacion(String descriptorEmisorTramitacion) {
		this.descriptorEmisorTramitacion = descriptorEmisorTramitacion;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Division))
			return false;
		Division castOther = (Division) other;
		return this.getId() != null && castOther.getId() != null && this.getId().equals(castOther.getId());
	}
}
