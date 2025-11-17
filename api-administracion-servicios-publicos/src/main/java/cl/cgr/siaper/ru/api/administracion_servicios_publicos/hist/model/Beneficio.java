package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model;

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
@Table(name = "TRA_BENEFICIOS")
public class Beneficio implements java.io.Serializable{
	
	private static final long serialVersionUID = 8567734461742983043L;
	private Long id;
	private String descripcion;
	private Long codigo;
	private Boolean inhabilidad;
	private Date version;
	private String codUsuarioBloq;
	private Set<BeneficioMateria> beneficiosMateria = new HashSet<BeneficioMateria>(0);

	@Id
	@SequenceGenerator(allocationSize = 1, name = "generator", sequenceName = "TRA_S_BENE_X_BENE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "X_BENE", unique = true, nullable = false, precision = 10, scale = 0)	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "D_BENE", length = 150)
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Column(name = "S_BENE", precision = 12, scale = 0)
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	@Column(name = "L_INHABILIDAD", length = 1)
	@Convert(converter = BooleanSiNoConverter.class)
	public Boolean getInhabilidad() {
		return inhabilidad;
	}
	public void setInhabilidad(Boolean inhabilidad) {
		this.inhabilidad = inhabilidad;
	}
	@Column(name = "C_USUARIO_BLOQ", length = 50)
	public String getCodUsuarioBloq() {
		return this.codUsuarioBloq;
	}

	public void setCodUsuarioBloq(String codUsuarioBloq) {
		this.codUsuarioBloq = codUsuarioBloq;
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
	
	public boolean equals(Beneficio b)
	{
		if (id != null && b != null && b.id != null)
			return id.equals(b.id);
		return false;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "beneficio")
	public Set<BeneficioMateria> getBeneficiosMateria() {
		return beneficiosMateria;
	}
	public void setBeneficiosMateria(Set<BeneficioMateria> beneficiosMateria) {
		this.beneficiosMateria = beneficiosMateria;
	}
	
}
