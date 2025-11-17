package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name = "ACCESO_USUARIO")
public class AccesoEscritorio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4559698628066908508L;

	private Long id;
	private Long run;
	private String dv;
	private Integer estado;
	
	@Id
	@SequenceGenerator(allocationSize = 1, name = "generator", sequenceName = "SEQ_ACCESOUSUARIO_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "ID", unique = true, nullable = false, precision = 20, scale = 0)
	public Long getId() {
		return id;
	}
	
	@Column(name = "RUN", unique = true, nullable = false, length = 8)
	public Long getRun() {
		return run;
	}
	
	@Column(name = "DV", length = 1)
	public String getDv() {
		return dv;
	}
	
	@Column(name = "ESTADO", length = 1)
	public Integer getEstado() {
		return estado;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setRun(Long run) {
		this.run = run;
	}
	public void setDv(String dv) {
		this.dv = dv;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	
	

}
