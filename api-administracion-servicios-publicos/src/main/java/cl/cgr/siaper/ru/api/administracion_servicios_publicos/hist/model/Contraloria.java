package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
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

import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;

import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.converter.BooleanSiNoConverter;

@Entity
@Audited
@Table(name = "TRA_CONTRALORIAS")
public class Contraloria implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4267029136541390105L;

	private Long id;
	private Date version;
	private String descripcion;
	private boolean activo;
	private String codUsuarioBloq;
	private Servicio servicio;
    private TipoServicio tipoServicio;
	private String membreteOficio;
    private String detalleOficio;

	public Contraloria() {
		
	}

	@Id
	@SequenceGenerator(allocationSize = 1, name = "generator", sequenceName = "TRA_S_CONT_X_CONT")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "X_CONT", unique = true, nullable = false, precision = 10, scale = 0)
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

	@Column(name = "D_CONT", nullable = false, length = 250)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "L_ACTIVO", nullable = false, length = 1)
	@Convert(converter = BooleanSiNoConverter.class)
	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Column(name = "C_USUARIO_BLOQ", length = 50)
	public String getCodUsuarioBloq() {
		return codUsuarioBloq;
	}

	public void setCodUsuarioBloq(String codUsuarioBloq) {
		this.codUsuarioBloq = codUsuarioBloq;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TISE_X_TISE", nullable = false)
    public TipoServicio getTipoServicio() {
        return this.tipoServicio;
    }

    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SERV_X_SERV")
    public Servicio getServicio() {
        return this.servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    @Column(name = "T_MEMBRETE_OFICIO", length = 4000)
    public String getMembreteOficio() {
        return membreteOficio;
    }

    public void setMembreteOficio(String membreteOficio) {
        this.membreteOficio = membreteOficio;
    }

    @Column(name = "T_DETALLE_OFICIO", length = 4000)
    public String getDetalleOficio() {
        return detalleOficio;
    }

    public void setDetalleOficio(String detalleOficio) {
        this.detalleOficio = detalleOficio;
    }

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Contraloria))
			return false;
		Contraloria castOther = (Contraloria) other;
		return this.getId() != null && castOther.getId() != null && this.getId().equals(castOther.getId());
	}
}
