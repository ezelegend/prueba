package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;

import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name = "TRA_COMENTARIOS_DOC")
public class Comentario implements java.io.Serializable, Comparable<Comentario>{
	
	
	private static final long serialVersionUID = -2339095558323687437L;
	private Long id;
	
	private Documento documento;
	private String comentario;
	private Date fecha;
	private String perfil;
	private String usuario;
	
	private Date version;
	private String codUsuarioBloq;

	@Id 
	@SequenceGenerator(allocationSize = 1, name = "generator", sequenceName = "TRA_S_CODO_X_CODO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "X_CODO", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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
	@Column(name = "C_USUARIO_BLOQ", length = 50)
	public String getCodUsuarioBloq() {
		return this.codUsuarioBloq;
	}

	public void setCodUsuarioBloq(String codUsuarioBloq) {
		this.codUsuarioBloq = codUsuarioBloq;
	}
	@Column(name = "T_COMENTARIO", nullable = false, length = 400)
	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "F_COMENTARIO", nullable = false, length = 7)
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	@Column(name = "S_PERF", nullable = false, length = 50)
	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	@Column(name = "C_USUARIO", nullable = false, length = 50)
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOCU_X_DOCU", nullable = false)
	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public int compareTo(Comentario o) {
		int res = fecha.compareTo(o.fecha);
		if (res == 0)
			res = id.compareTo(o.id);
		return -res;
	}

	public String obtenerFormatFecha(){
		
		String result = "";
		if(this.fecha!=null){
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy HH:mm");
			result = sdf.format(this.fecha);
		}
		return result;
	}
 

}
