package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ACCESO_USUARIO database table.
 * 
 */
@Entity
@Table(name="ACCESO_USUARIO")
@NamedQuery(name="AccesoUsuario.findAll", query="SELECT a FROM AccesoUsuario a")
public class AccesoUsuario implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private String dv;
	private BigDecimal estado;
	private BigDecimal run;

	public AccesoUsuario() {
	}


	@Id
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getDv() {
		return this.dv;
	}

	public void setDv(String dv) {
		this.dv = dv;
	}


	public BigDecimal getEstado() {
		return this.estado;
	}

	public void setEstado(BigDecimal estado) {
		this.estado = estado;
	}


	public BigDecimal getRun() {
		return this.run;
	}

	public void setRun(BigDecimal run) {
		this.run = run;
	}

}