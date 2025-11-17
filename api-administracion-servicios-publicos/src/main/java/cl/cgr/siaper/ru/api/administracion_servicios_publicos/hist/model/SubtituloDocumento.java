package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model;

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
@Table(name = "TRA_SUBTITULOS_DOCUMENTO")
public class SubtituloDocumento implements java.io.Serializable {
	
	private static final long serialVersionUID = -6941152092049982136L;
	
	private Long id;
	private Documento documento;
	private Date version;
	private String codUsuarioBloq;
	private Long codSiaperSubtitulo;
	private String descripcionSiaperSubtitulo;
	private Long codSiaperItem;
	private String descripcionSiaperItem;
	private Long codSiaperAsignacion;
	private String descripcionSiaperAsignacion;
	private String comentario;
	
	
	@Id
	@SequenceGenerator(allocationSize = 1, name = "generator", sequenceName = "TRA_S_SUDO_X_SUDO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "X_SUDO", unique = true, nullable = false, precision = 10, scale = 0)
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
	
	@Column(name = "S_SUBTITULO", precision = 12, nullable=false, scale = 0)
	public Long getCodSiaperSubtitulo() {
		return codSiaperSubtitulo;
	}

	public void setCodSiaperSubtitulo(Long codSiaperSubtitulo) {
		this.codSiaperSubtitulo = codSiaperSubtitulo;
	}
	
	@Column(name = "D_SUBTITULO", nullable = false, length = 255)
	public String getDescripcionSiaperSubtitulo() {
		return descripcionSiaperSubtitulo;
	}

	public void setDescripcionSiaperSubtitulo(String descripcionSiaperSubtitulo) {
		this.descripcionSiaperSubtitulo = descripcionSiaperSubtitulo;
	}
	
	@Column(name = "S_ITEM", precision = 12, nullable=false, scale = 0)
	public Long getCodSiaperItem() {
		return codSiaperItem;
	}

	public void setCodSiaperItem(Long codSiaperItem) {
		this.codSiaperItem = codSiaperItem;
	}

	@Column(name = "D_ITEM", nullable = false, length = 255)
	public String getDescripcionSiaperItem() {
		return descripcionSiaperItem;
	}

	public void setDescripcionSiaperItem(String descripcionSiaperItem) {
		this.descripcionSiaperItem = descripcionSiaperItem;
	}

	@Column(name = "S_ASIGNACION", precision = 12, nullable=false, scale = 0)
	public Long getCodSiaperAsignacion() {
		return codSiaperAsignacion;
	}

	public void setCodSiaperAsignacion(Long codSiaperAsignacion) {
		this.codSiaperAsignacion = codSiaperAsignacion;
	}

	@Column(name = "D_ASIGNACION", nullable = false, length = 255)
	public String getDescripcionSiaperAsignacion() {
		return descripcionSiaperAsignacion;
	}

	public void setDescripcionSiaperAsignacion(String descripcionSiaperAsignacion) {
		this.descripcionSiaperAsignacion = descripcionSiaperAsignacion;
	}
	
	@Column(name = "T_COMENTARIO", length = 255)
	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOCU_X_DOCU", nullable = false)
	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}
	
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SubtituloDocumento))
			return false;
		SubtituloDocumento castOther = (SubtituloDocumento) other;
		return this.getId() != null && castOther.getId() != null && this.getId().equals(castOther.getId());
	}
	
}
