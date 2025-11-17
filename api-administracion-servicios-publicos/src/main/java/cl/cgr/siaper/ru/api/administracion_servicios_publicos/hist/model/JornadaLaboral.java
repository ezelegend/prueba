package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;

import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.converter.BooleanSiNoConverter;

@Entity
@Audited
@Table(name = "TRA_JORNADAS_LABORALES", uniqueConstraints = @UniqueConstraint(columnNames = "X_JOLA"))
public class JornadaLaboral implements java.io.Serializable{

	private static final long serialVersionUID = 7443169647849611081L;
	
	private Long id;
	private Long codSiaper;
	private String descripcion;
	private Boolean activo;
	private String codUsuarioBloq;
	
	public JornadaLaboral() {
		
	}
	
	@Id
	@SequenceGenerator(allocationSize = 1, name = "generator", sequenceName = "TRA_S_JOLA_X_JOLA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "X_JOLA", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "S_JOLA", precision = 12, nullable=false, scale = 0)
	public Long getCodSiaper() {
		return codSiaper;
	}
	
	public void setCodSiaper(Long codSiaper) {
		this.codSiaper = codSiaper;
	}
	
	@Column(name = "D_JOLA", nullable = false, length = 150)
	public String getDescripcion() {
		return this.descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "L_ACTIVO", length = 1)
	@Convert(converter = BooleanSiNoConverter.class)
	public Boolean getActivo() {
		return this.activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
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
		if (!(other instanceof ArticuloMateria))
			return false;
		ArticuloMateria castOther = (ArticuloMateria) other;
		return this.getId() != null && castOther.getId() != null && this.getId().equals(castOther.getId());
	}
	
	public String toString() {
		return "Descripción Jornada Laboral: " + this.descripcion;
	}
	
}
