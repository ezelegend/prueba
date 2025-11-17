package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model;

import java.io.Serializable;
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
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Version;

//import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;

import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.converter.BooleanSiNoConverter;

@Entity
@Audited
@Table(name = "TRA_USUARIOS_DIVISION", uniqueConstraints = {@UniqueConstraint(columnNames = "C_USUARIO")})
public class UsuarioDivision implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2384582101180621638L;
	
	private Long id;
	private Date version;
	private Division division;
	private String codigo;
	private String run;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private boolean activo;
	private String codUsuarioBloq;
	private String email;
	
	public UsuarioDivision() {
		
	}

	@Id
	@SequenceGenerator(allocationSize = 1, name = "generator", sequenceName = "TRA_S_USDI_X_USDI")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "X_USDI", unique = true, nullable = false, precision = 10, scale = 0)
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DIVI_X_DIVI", nullable = false)
	public Division getDivision() {
		return division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}

	@Column(name = "C_USUARIO", unique = true, nullable = false, length = 50)
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Column(name = "T_RUN", nullable = false, length = 10)
	public String getRun() {
		return run;
	}

	public void setRun(String run) {
		this.run = run;
	}

	@Column(name = "T_NOMBRE", length = 150)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "T_APELLIDO1", length = 150)
	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	@Column(name = "T_APELLIDO2", length = 150)
	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
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

	@Column(name = "T_CORREO_ELECTRONICO", length = 150)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UsuarioDivision))
			return false;
		UsuarioDivision castOther = (UsuarioDivision) other;
		return this.getId() != null && castOther.getId() != null && this.getId().equals(castOther.getId());
	}
}
