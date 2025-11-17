package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TRA_ACCIONES_DOCUMENTOS_HIST")
public class AccionDocumentoHistorico implements java.io.Serializable {

	private static final long serialVersionUID = -4448371452721966052L;
	
	private Long id;
	private Long revision;
	private Long operacion;
	private String codigo;
	private String descripcion;
	private String externos;

	public AccionDocumentoHistorico() {
	}

	@Id 
	@Column(name = "X_ACDO", nullable = false, precision = 10, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "N_REVISION", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getRevision() {
		return this.revision;
	}

	public void setRevision(Long revision) {
		this.revision = revision;
	}

	@Column(name = "V_OPERACION", nullable = false, precision = 3, scale = 0)
	public Long getOperacion() {
		return operacion;
	}

	public void setOperacion(Long operacion) {
		this.operacion = operacion;
	}	

	@Column(name = "C_ACDO", unique = true, nullable = false, length = 10)
	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Column(name = "D_ACDO", nullable = false, length = 240)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "L_EXTERNOS", nullable = false, length = 1)
	public String getExternos() {
		return this.externos;
	}

	public void setExternos(String externos) {
		this.externos = externos;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AccionDocumentoHistorico))
			return false;
		AccionDocumentoHistorico castOther = (AccionDocumentoHistorico) other;
		return this.getId() != null && castOther.getId() != null && this.getId().equals(castOther.getId());
	}
	
	public String toString() {
		return "Código: " + codigo + ", descripción: " + descripcion;
	}
}
