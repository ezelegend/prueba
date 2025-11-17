package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
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
import jakarta.persistence.Version;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

@Entity
@Audited
@AuditTable("TRA_CARGA_FORM_HIST")
@Table(name = "TRA_CARGA_FORM")
public class CargaFormulario implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7479111131937277236L;
	
	private Long id;
	private String usuario;
	private Formulario formulario;
	private CasoDocumento casoDocumento;
	private Long tiempoCarga;
	private Date version;
	private String tipoLectura;
	private Set<CargaWsAsin> hechosInicialesCargados = new HashSet<CargaWsAsin>(0);
	private Set<CargaPkg> pkgCargados = new HashSet<CargaPkg>(0);
	private Set<CargaServiciosWeb> wsCargados = new HashSet<CargaServiciosWeb>(0);
	private Set<CargaCaminosTra> caminosCargados = new HashSet<CargaCaminosTra>(0);
	
	@Id
	@SequenceGenerator(allocationSize = 1, name = "generator", sequenceName = "TRA_S_CAFO_X_CAFO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "X_CAFO", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
		
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CADO_X_CADO", nullable = false)
	public CasoDocumento getCasoDocumento() {
		return casoDocumento;
	}
	
	public void setCasoDocumento(CasoDocumento casoDocumento) {
		this.casoDocumento = casoDocumento;
	}
	
	@Version
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "F_VERSION", length = 7)
	public Date getVersion() {
		return version;
	}
	
	/**
	 * @return the usuario
	 */
	@Column(name = "C_USUARIO", length = 30)
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the formulario
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FORM_X_FORM", nullable = false)
	public Formulario getFormulario() {
		return formulario;
	}

	/**
	 * @param formulario the formulario to set
	 */
	public void setFormulario(Formulario formulario) {
		this.formulario = formulario;
	}

	/**
	 * @return the tiempoCarga
	 */
	@Column(name = "N_TIEMPO_CARGA")
	public Long getTiempoCarga() {
		return tiempoCarga;
	}

	/**
	 * @param tiempoCarga the tiempoCarga to set
	 */
	public void setTiempoCarga(Long tiempoCarga) {
		this.tiempoCarga = tiempoCarga;
	}
	
	public void setVersion(Date version) {
		this.version = version;
	}
	
	/**
	 * @return the hechosInicialesCargados
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cargaFormulario", cascade = CascadeType.ALL)
	public Set<CargaWsAsin> getHechosInicialesCargados() {
		return hechosInicialesCargados;
	}

	/**
	 * @param hechosInicialesCargados the hechosInicialesCargados to set
	 */
	public void setHechosInicialesCargados(Set<CargaWsAsin> hechosInicialesCargados) {
		this.hechosInicialesCargados = hechosInicialesCargados;
	}

	/**
	 * @return the pkgCargados
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cargaFormulario", cascade = CascadeType.ALL)
	public Set<CargaPkg> getPkgCargados() {
		return pkgCargados;
	}

	/**
	 * @param pkgCargados the pkgCargados to set
	 */
	public void setPkgCargados(Set<CargaPkg> pkgCargados) {
		this.pkgCargados = pkgCargados;
	}

	/**
	 * @return the wsCargados
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cargaFormulario", cascade = CascadeType.ALL)
	public Set<CargaServiciosWeb> getWsCargados() {
		return wsCargados;
	}

	/**
	 * @param wsCargados the wsCargados to set
	 */
	public void setWsCargados(Set<CargaServiciosWeb> wsCargados) {
		this.wsCargados = wsCargados;
	}
	
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CargaFormulario))
			return false;
		CargaFormulario castOther = (CargaFormulario) other;
		return this.getId() != null && castOther.getId() != null && this.getId().equals(castOther.getId());
	}

	/**
	 * @return the caminosCargados
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cargaFormulario", cascade = CascadeType.ALL)
	public Set<CargaCaminosTra> getCaminosCargados() {
		return caminosCargados;
	}

	/**
	 * @param caminosCargados the caminosCargados to set
	 */
	public void setCaminosCargados(Set<CargaCaminosTra> caminosCargados) {
		this.caminosCargados = caminosCargados;
	}
	
	/**
	 * @return the tipoLectura
	 */
	@Column(name = "C_TIPO_CARGA")
	public String getTipoLectura() {
		return tipoLectura;
	}

	/**
	 * @param tipoLectura the tipoLectura to set
	 */
	public void setTipoLectura(String tipoLectura) {
		this.tipoLectura = tipoLectura;
	}

}
