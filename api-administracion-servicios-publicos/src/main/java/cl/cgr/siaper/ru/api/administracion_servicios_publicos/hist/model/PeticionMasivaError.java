package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model;

import java.io.Serializable;
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
@Table(name = "TRA_PETICIONES_MASIVA_ERR")
public class PeticionMasivaError implements Serializable {

    private static final long serialVersionUID = -1995867434806437165L;
    private Long id;
    private Date version;
    private String error;
    private PeticionMasiva peticionMasiva;

    public PeticionMasivaError() {
    }

    @Id
    @SequenceGenerator(allocationSize = 1, name = "generator", sequenceName = "TRA_S_PEMA_X_PEMA_ERR")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "X_PEMA_ERR", unique = true, nullable = false, precision = 10, scale = 0)
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
    
    @Column(name = "X_ERROR", nullable = false, length = 4000)
    public String getError() {
        return this.error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PEMA_X_PEMA", nullable = false)
    public PeticionMasiva getPeticionMasiva() {
        return peticionMasiva; 
    }
    
    public void setPeticionMasiva(PeticionMasiva peticionMasiva) {
        this.peticionMasiva = peticionMasiva;
    }
    
    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof PeticionMasivaError))
            return false;
        PeticionMasivaError castOther = (PeticionMasivaError) other;
        return this.getId() != null && castOther.getId() != null && this.getId().equals(castOther.getId());
    }
}