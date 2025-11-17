package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlTransient;

import org.hibernate.envers.Audited;

import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.Region;

@Entity
@Audited
@Table(name="TBLREGION", schema = "SIAPER3")

public class RegionSiaper implements java.io.Serializable {

	private static final long serialVersionUID = 4055855352538151696L;
	@Id
	@Column(name="REGCODIGO")
	private Long id;
	@Column(name="REGDESCRIPCION")
	private String descriptor;
	@Column(name="REGDESCRIPCIONNUEVA")
	private String descriptorNuevo;
	@Column(name="REGESTADO")
	private Integer activo;
	@Column(name="REGORDENNORMATIVA")
	private Integer ordenNormativa;
	@OneToMany(mappedBy="regionSiaper")
	private Set<Region> regionesTra = new HashSet<Region>();
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescriptor() {
		return descriptor;
	}

	public void setDescriptor(String descriptor) {
		this.descriptor = descriptor;
	}

	public String getDescriptorNuevo() {
		return descriptorNuevo;
	}

	public void setDescriptorNuevo(String descriptorNuevo) {
		this.descriptorNuevo = descriptorNuevo;
	}

	public Integer getActivo() {
		return activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}

	@XmlTransient
	public Set<Region> getRegionesTra() {
		return regionesTra;
	}

	public void setRegionesTra(Set<Region> regionesTra) {
		this.regionesTra = regionesTra;
	}

	public Integer getOrdenNormativa() {
		return ordenNormativa;
	}

	public void setOrdenNormativa(Integer ordenNormativa) {
		this.ordenNormativa = ordenNormativa;
	}
}
