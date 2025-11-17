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
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Version;
import org.hibernate.envers.Audited;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * RuUsuarioPerfil - Replica entity for RU_USUARIOS_PERFILES table.
 * Mirrors TRA_USUARIOS_X_PERFILES structure for dual-write strategy.
 */
@Entity
@Audited
@Table(name = "RU_USUARIOS_PERFILES", uniqueConstraints = @UniqueConstraint(columnNames = { "USUA_X_USUA", "PERF_X_PERF" }))
public class RuUsuarioPerfil implements java.io.Serializable {

    private static final long serialVersionUID = 1650864491193475436L;

    private Long id;
    private Date version;
    private RuUsuario ruUsuario;
    private Perfil perfil;
    private String codUsuarioBloq;

    public RuUsuarioPerfil() {
    }

    @Id
    @SequenceGenerator(allocationSize = 1, name = "generator", sequenceName = "RU_S_USPE_X_USPE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "X_USPE", unique = true, nullable = false, precision = 10, scale = 0)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USUA_X_USUA", nullable = false)
    @JsonIgnore
    public RuUsuario getRuUsuario() {
        return this.ruUsuario;
    }

    public void setRuUsuario(RuUsuario ruUsuario) {
        this.ruUsuario = ruUsuario;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERF_X_PERF", nullable = false)
    public Perfil getPerfil() {
        return this.perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    @Column(name = "C_USUARIO_BLOQ", length = 50)
    public String getCodUsuarioBloq() {
        return this.codUsuarioBloq;
    }

    public void setCodUsuarioBloq(String codUsuarioBloq) {
        this.codUsuarioBloq = codUsuarioBloq;
    }

    @Override
    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof RuUsuarioPerfil))
            return false;
        RuUsuarioPerfil castOther = (RuUsuarioPerfil) other;
        return this.getId() != null && castOther.getId() != null && this.getId().equals(castOther.getId());
    }
}
