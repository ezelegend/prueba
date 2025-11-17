package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model;

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
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Version;
import org.hibernate.envers.Audited;
import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.converter.BooleanSiNoConverter;

/**
 * RuUsuario - Replica entity for RU_USUARIOS table.
 * Mirrors TRA_USUARIOS structure for dual-write strategy.
 */
@Entity
@Audited
@Table(name = "RU_USUARIOS", uniqueConstraints = {
    @UniqueConstraint(columnNames = "T_RUN"),
    @UniqueConstraint(columnNames = "C_USUARIO")
})
public class RuUsuario implements java.io.Serializable {

    private static final long serialVersionUID = 1162367796282762394L;

    private Long id;
    private Date version;
    private Servicio servicio;
    private String codigo;
    private String run;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String origen;
    private Boolean activo;
    private String codUsuarioBloq;
    private String email;
    private String configFirma;
    private String configFirmaPDF;
    private String usuarioConfigFirma;

    public RuUsuario() {
    }

    @Id
    @SequenceGenerator(allocationSize = 1, name = "generator", sequenceName = "RU_S_USUA_X_USUA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "X_USUA", unique = true, nullable = false, precision = 10, scale = 0)
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
    @JoinColumn(name = "SERV_X_SERV", nullable = false)
    public Servicio getServicio() {
        return this.servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    @Column(name = "C_USUARIO", unique = true, nullable = false, length = 50)
    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Column(name = "T_RUN", unique = true, nullable = false, length = 10)
    public String getRun() {
        return this.run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    @Column(name = "T_NOMBRE", length = 150)
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "T_APELLIDO1", length = 150)
    public String getApellido1() {
        return this.apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    @Column(name = "T_APELLIDO2", length = 150)
    public String getApellido2() {
        return this.apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    @Column(name = "V_ORIGEN", length = 1)
    public String getOrigen() {
        return this.origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    @Column(name = "L_ACTIVO", nullable = false, length = 1)
    @Convert(converter = BooleanSiNoConverter.class)
    public Boolean getActivo() {
        return this.activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @Column(name = "C_USUARIO_BLOQ", length = 50)
    public String getCodUsuarioBloq() {
        return this.codUsuarioBloq;
    }

    public void setCodUsuarioBloq(String codUsuarioBloq) {
        this.codUsuarioBloq = codUsuarioBloq;
    }

    @Column(name = "T_CORREO_ELECTRONICO", length = 150)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "T_CONF_FIRMA", length = 150)
    public String getConfigFirma() {
        return configFirma;
    }

    public void setConfigFirma(String configFirma) {
        this.configFirma = configFirma;
    }

    @Column(name = "T_USUARIO_CONF_FIRMA_PDF", length = 150)
    public String getConfigFirmaPDF() {
        return configFirmaPDF;
    }

    public void setConfigFirmaPDF(String configFirmaPDF) {
        this.configFirmaPDF = configFirmaPDF;
    }

    @Column(name = "T_USUARIO_CONF_FIRMA", length = 150)
    public String getUsuarioConfigFirma() {
        return usuarioConfigFirma;
    }

    public void setUsuarioConfigFirma(String usuarioConfigFirma) {
        this.usuarioConfigFirma = usuarioConfigFirma;
    }

    @Override
    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof RuUsuario))
            return false;
        RuUsuario castOther = (RuUsuario) other;
        return this.getId() != null && castOther.getId() != null && this.getId().equals(castOther.getId());
    }

    @Override
    public String toString() {
        return "RuUsuario: " + codigo + ", RUN: " + run + " - " + apellido1 + ", " + nombre;
    }
}
