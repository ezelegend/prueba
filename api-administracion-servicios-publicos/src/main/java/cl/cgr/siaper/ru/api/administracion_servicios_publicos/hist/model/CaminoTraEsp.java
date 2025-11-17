package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
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
import jakarta.persistence.Transient;
import jakarta.persistence.Version;

import org.hibernate.envers.Audited;

import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.converter.SinoTipo;

@Entity
@Audited
@Table(name = "TRA_CAMINOS_TRA_ESP")
public class CaminoTraEsp implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 491234900131040533L;
	
	private Long id;
	private Date version;
	private String codUsuarioBloq;
	private String calidad;
	private Formulario formulario;	
	private Dotacion dotacion;
	private Subcargo subcargo;
	private Set<ReqartCaminoTraEsp> reqartCaminoTraEspes = new HashSet<ReqartCaminoTraEsp>(0);
	
	// Transient attributes
	private int orden;
	private List<String> alternativasReqArt;
	
	public CaminoTraEsp() {
		
	}
	
	public CaminoTraEsp(Formulario form) {
		this.formulario = form;
	}

	@SequenceGenerator(allocationSize = 1, name = "generator", sequenceName = "TRA_S_CTRE_X_CTRE")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "X_CTRE", unique = true, nullable = false, precision = 10, scale = 0)
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

	@Column(name = "V_CALIDAD", length = 1)
	public String getCalidad() {
		return calidad;
	}

	public void setCalidad(String calidad) {
		this.calidad = calidad;
	}

	@ManyToOne
	@JoinColumn(name = "FORM_X_FORM", nullable = false)
	public Formulario getFormulario() {
		return formulario;
	}

	public void setFormulario(Formulario formulario) {
		this.formulario = formulario;
	}

	@ManyToOne
	@JoinColumn(name = "RPLS_X_RPLS", nullable = false)
	public Dotacion getDotacion() {
		return dotacion;
	}

	public void setDotacion(Dotacion dotacion) {
		this.dotacion = dotacion;
	}

	@ManyToOne
	@JoinColumn(name = "SUBC_X_SUBC")
	public Subcargo getSubcargo() {
		return subcargo;
	}

	public void setSubcargo(Subcargo subcargo) {
		this.subcargo = subcargo;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "caminoTraEsp")
	public Set<ReqartCaminoTraEsp> getReqartCaminoTraEspes() {
		return reqartCaminoTraEspes;
	}

	public void setReqartCaminoTraEspes(Set<ReqartCaminoTraEsp> reqartCaminoTraEspes) {
		this.reqartCaminoTraEspes = reqartCaminoTraEspes;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CaminoTraEsp))
			return false;
		CaminoTraEsp castOther = (CaminoTraEsp) other;
		return this.getId() != null && castOther.getId() != null && this.getId().equals(castOther.getId());
	}
	
	
	public String toString()
	{
		return getDescripcion () ;
	}
	
	@Transient
	public String getDescripcion () 
	{
		Set<ReqartCaminoTraEsp> set = this.getReqartCaminoTraEspes();
		List<ReqartCaminoTraEsp> list = new ArrayList<ReqartCaminoTraEsp>();
		list.addAll(set);
		Collections.sort(list);
		//String desc = id + " ";
		String desc = "";
//		try { 
//			desc += "[RPLS:"+this.dotacion+"]";
//		}catch(Exception e){			
//		}		
//		try { 
//			if (this.getSubcargo()==null)
//				desc += "[Subcargo:]";
//			else
//				desc += "[Subcargo:"+this.getSubcargo().getDescripcion()+"]";
//		}catch(Exception e){			
//		}
		
		Iterator<ReqartCaminoTraEsp> it = list.iterator();
		while (it.hasNext())
		{
			ReqartCaminoTraEsp r = it.next();
			desc += r.getRequisitoArticulo().getRequisito().getCodigo() + "=" + new SinoTipo(r.getAlternativa()).getCode()+",";
			//System.out.println(desc+" "+r.getNumOrden());
		}
		return desc;
			
	}

	@Transient
	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	@Transient
	public List<String> getAlternativasReqArt() {
		return alternativasReqArt;
	}

	public void setAlternativasReqArt(List<String> alternativasReqArt) {
		this.alternativasReqArt = alternativasReqArt;
	}	
}
