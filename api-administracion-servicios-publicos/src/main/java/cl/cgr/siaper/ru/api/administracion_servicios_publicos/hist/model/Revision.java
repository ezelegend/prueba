package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model;

import java.io.Serializable;
import java.util.Date;

public class Revision  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8790707091506942211L;

	private String usuario;
	
	private Date fecha;
	
	private String descripcion;
	
	public Revision(String usuario, Date fecha, String descripcion) {
		this.usuario = usuario;
		this.fecha = fecha;
		this.descripcion = descripcion;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
