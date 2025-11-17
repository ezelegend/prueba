package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import org.hibernate.annotations.Type;

import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.converter.BooleanSiNoConverter;

@Entity
@Table(name = "TRA_ESTADISTICAS_CASO")
public class EstadisticasCaso implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8783173352233938274L;

	private Long id;
	private CasoDocumento caso;
	private Long numPagesForm;
	private String pagesVisitadas;
	private boolean datosCasoVisitados;
	private boolean convenioVisitado;
	private Long numAdjuntos;
	private String adjuntosVisitados;
	private Long numPagesFormJArea;
	private String pagesVisitadasJArea;
	private boolean datosCasoVisitadosJArea;
	private boolean convenioVisitadoJArea;
	private Long numAdjuntosJArea;
	private String adjuntosVisitadosJArea;
	private Long numPagesFormJDPAE;
	private String pagesVisitadasJDPAE;
	private boolean datosCasoVisitadosJDPAE;
	private boolean convenioVisitadoJDPAE;
	private Long numAdjuntosJDPAE;
	private String adjuntosVisitadosJDPAE;
	private Long numPagesFormContralor;
	private String pagesVisitadasContralor;
	private boolean datosCasoVisitadosContralor;
	private boolean convenioVisitadoContralor;
	private Long numAdjuntosContralor;
	private String adjuntosVisitadosContralor;
	private String adjuntosVisitadosDeclarAntece;
	
	public EstadisticasCaso() {
		
	}

	@Id
	@SequenceGenerator(allocationSize = 1, name = "generator", sequenceName = "TRA_S_ESCA_X_ESCA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "X_ESCA", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CADO_X_CADO", nullable = false)
	public CasoDocumento getCaso() {
		return caso;
	}

	public void setCaso(CasoDocumento caso) {
		this.caso = caso;
	}

	@Column(name = "N_PAGES_FORM", precision = 3, scale = 0)
	public Long getNumPagesForm() {
		return numPagesForm;
	}

	public void setNumPagesForm(Long numPagesForm) {
		this.numPagesForm = numPagesForm;
	}

	@Column(name = "T_PAGES_VISITADAS", length = 200)
	public String getPagesVisitadas() {
		return pagesVisitadas;
	}

	public void setPagesVisitadas(String pagesVisitadas) {
		this.pagesVisitadas = pagesVisitadas;
	}

	@Column(name = "L_DATOS_CASO_VISITADO", length = 1)
	@Convert(converter = BooleanSiNoConverter.class)
	public boolean isDatosCasoVisitados() {
		return datosCasoVisitados;
	}

	public void setDatosCasoVisitados(boolean datosCasoVisitados) {
		this.datosCasoVisitados = datosCasoVisitados;
	}
	
	@Column(name = "L_CONVENIO_VISITADO", length = 1)
	@Convert(converter = BooleanSiNoConverter.class)
	public boolean isConvenioVisitado() {
		return convenioVisitado;
	}

	public void setConvenioVisitado(boolean convenioVisitado) {
		this.convenioVisitado = convenioVisitado;
	}
	
	@Column(name = "N_ADJUNTOS", precision = 3, scale = 0)
	public Long getNumAdjuntos() {
		return numAdjuntos;
	}

	public void setNumAdjuntos(Long numAdjuntos) {
		this.numAdjuntos = numAdjuntos;
	}

	@Column(name = "T_ADJUNTOS_VISITADOS", length = 200)
	public String getAdjuntosVisitados() {
		return adjuntosVisitados;
	}

	public void setAdjuntosVisitados(String adjuntosVisitados) {
		this.adjuntosVisitados = adjuntosVisitados;
	}

	@Column(name = "N_PAGES_FORM_JAREA", precision = 3, scale = 0)
	public Long getNumPagesFormJArea() {
		return numPagesFormJArea;
	}

	public void setNumPagesFormJArea(Long numPagesFormJArea) {
		this.numPagesFormJArea = numPagesFormJArea;
	}

	@Column(name = "T_PAGES_VISITADAS_JAREA", length = 200)
	public String getPagesVisitadasJArea() {
		return pagesVisitadasJArea;
	}

	public void setPagesVisitadasJArea(String pagesVisitadasJArea) {
		this.pagesVisitadasJArea = pagesVisitadasJArea;
	}

	@Column(name = "L_DATOS_CASO_VISITADO_JAREA", length = 1)
	@Convert(converter = BooleanSiNoConverter.class)
	public boolean isDatosCasoVisitadosJArea() {
		return datosCasoVisitadosJArea;
	}

	public void setDatosCasoVisitadosJArea(boolean datosCasoVisitadosJArea) {
		this.datosCasoVisitadosJArea = datosCasoVisitadosJArea;
	}

	@Column(name = "L_CONVENIO_VISITADO_JAREA", length = 1)
	@Convert(converter = BooleanSiNoConverter.class)
	public boolean isConvenioVisitadoJArea() {
		return convenioVisitadoJArea;
	}

	public void setConvenioVisitadoJArea(boolean convenioVisitadoJArea) {
		this.convenioVisitadoJArea = convenioVisitadoJArea;
	}

	@Column(name = "N_ADJUNTOS_JAREA", precision = 3, scale = 0)
	public Long getNumAdjuntosJArea() {
		return numAdjuntosJArea;
	}

	public void setNumAdjuntosJArea(Long numAdjuntosJArea) {
		this.numAdjuntosJArea = numAdjuntosJArea;
	}

	@Column(name = "T_ADJUNTOS_VISITADOS_JAREA", length = 200)
	public String getAdjuntosVisitadosJArea() {
		return adjuntosVisitadosJArea;
	}

	public void setAdjuntosVisitadosJArea(String adjuntosVisitadosJArea) {
		this.adjuntosVisitadosJArea = adjuntosVisitadosJArea;
	}

	@Column(name = "N_PAGES_FORM_JDPAE", precision = 3, scale = 0)
	public Long getNumPagesFormJDPAE() {
		return numPagesFormJDPAE;
	}

	public void setNumPagesFormJDPAE(Long numPagesFormJDPAE) {
		this.numPagesFormJDPAE = numPagesFormJDPAE;
	}

	@Column(name = "T_PAGES_VISITADAS_JDPAE", length = 200)
	public String getPagesVisitadasJDPAE() {
		return pagesVisitadasJDPAE;
	}

	public void setPagesVisitadasJDPAE(String pagesVisitadasJDPAE) {
		this.pagesVisitadasJDPAE = pagesVisitadasJDPAE;
	}

	@Column(name = "L_DATOS_CASO_VISITADO_JDPAE", length = 1)
	@Convert(converter = BooleanSiNoConverter.class)
	public boolean isDatosCasoVisitadosJDPAE() {
		return datosCasoVisitadosJDPAE;
	}

	public void setDatosCasoVisitadosJDPAE(boolean datosCasoVisitadosJDPAE) {
		this.datosCasoVisitadosJDPAE = datosCasoVisitadosJDPAE;
	}

	@Column(name = "L_CONVENIO_VISITADO_JDPAE", length = 1)
	@Convert(converter = BooleanSiNoConverter.class)
	public boolean isConvenioVisitadoJDPAE() {
		return convenioVisitadoJDPAE;
	}

	public void setConvenioVisitadoJDPAE(boolean convenioVisitadoJDPAE) {
		this.convenioVisitadoJDPAE = convenioVisitadoJDPAE;
	}

	@Column(name = "N_ADJUNTOS_JDPAE", precision = 3, scale = 0)
	public Long getNumAdjuntosJDPAE() {
		return numAdjuntosJDPAE;
	}

	public void setNumAdjuntosJDPAE(Long numAdjuntosJDPAE) {
		this.numAdjuntosJDPAE = numAdjuntosJDPAE;
	}

	@Column(name = "T_ADJUNTOS_VISITADOS_JDPAE", length = 200)
	public String getAdjuntosVisitadosJDPAE() {
		return adjuntosVisitadosJDPAE;
	}

	public void setAdjuntosVisitadosJDPAE(String adjuntosVisitadosJDPAE) {
		this.adjuntosVisitadosJDPAE = adjuntosVisitadosJDPAE;
	}

	@Column(name = "N_PAGES_FORM_CONTR", precision = 3, scale = 0)
	public Long getNumPagesFormContralor() {
		return numPagesFormContralor;
	}

	public void setNumPagesFormContralor(Long numPagesFormContralor) {
		this.numPagesFormContralor = numPagesFormContralor;
	}

	@Column(name = "T_PAGES_VISITADAS_CONTR", length = 200)
	public String getPagesVisitadasContralor() {
		return pagesVisitadasContralor;
	}

	public void setPagesVisitadasContralor(String pagesVisitadasContralor) {
		this.pagesVisitadasContralor = pagesVisitadasContralor;
	}

	@Column(name = "L_DATOS_CASO_VISITADO_CONTR", length = 1)
	@Convert(converter = BooleanSiNoConverter.class)
	public boolean isDatosCasoVisitadosContralor() {
		return datosCasoVisitadosContralor;
	}

	public void setDatosCasoVisitadosContralor(boolean datosCasoVisitadosContralor) {
		this.datosCasoVisitadosContralor = datosCasoVisitadosContralor;
	}

	@Column(name = "L_CONVENIO_VISITADO_CONTR", length = 1)
	@Convert(converter = BooleanSiNoConverter.class)
	public boolean isConvenioVisitadoContralor() {
		return convenioVisitadoContralor;
	}

	public void setConvenioVisitadoContralor(boolean convenioVisitadoContralor) {
		this.convenioVisitadoContralor = convenioVisitadoContralor;
	}

	@Column(name = "N_ADJUNTOS_CONTR", precision = 3, scale = 0)
	public Long getNumAdjuntosContralor() {
		return numAdjuntosContralor;
	}

	public void setNumAdjuntosContralor(Long numAdjuntosContralor) {
		this.numAdjuntosContralor = numAdjuntosContralor;
	}

	@Column(name = "T_ADJUNTOS_VISITADOS_CONTR", length = 200)
	public String getAdjuntosVisitadosContralor() {
		return adjuntosVisitadosContralor;
	}

	public void setAdjuntosVisitadosContralor(String adjuntosVisitadosContralor) {
		this.adjuntosVisitadosContralor = adjuntosVisitadosContralor;
	}
	
	@Column(name = "T_ADJUNTOS_VISITADOS_DECAN", length = 200)
	public String getAdjuntosVisitadosDeclarAntece() {
		return adjuntosVisitadosDeclarAntece;
	}

	public void setAdjuntosVisitadosDeclarAntece(
			String adjuntosVisitadosDeclarAntece) {
		this.adjuntosVisitadosDeclarAntece = adjuntosVisitadosDeclarAntece;
	}
}
