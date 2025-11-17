package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model;

import java.io.Serializable;

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

import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name = "TRA_EST_FOR_MINEDUC")
public class MineducEnsenanzaMedia implements Serializable {

	private static final long serialVersionUID = -3414531620353173865L;

	private Long id;
	private String descripcion;
	private EnsenianzaMedia ensenanzaMedia;
	
	public MineducEnsenanzaMedia() {
		
	}
	
	@Id
	@SequenceGenerator(allocationSize = 1, name = "generator", sequenceName = "TRA_S_MIME_X_MIME")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "X_MIME", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "D_MIME", length = 240)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ENME_X_ENME", nullable = false)
	public EnsenianzaMedia getEnsenanzaMedia() {
		return ensenanzaMedia;
	}

	public void setEnsenanzaMedia(EnsenianzaMedia ensenanzaMedia) {
		this.ensenanzaMedia = ensenanzaMedia;
	}
}
