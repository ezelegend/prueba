package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model;

import java.io.Serializable;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.converter.BooleanSiNoConverter;

/**
 * RuMetodoFirmaRelacion - Replica entity for RU_METODOS_FIRMA_RELACION table.
 * Mirrors TRA_METODOS_FIRMA_RELACION structure for dual-write strategy.
 */
@Entity
@Table(name = "RU_METODOS_FIRMA_RELACION")
public class RuMetodoFirmaRelacion implements Serializable {

    private static final long serialVersionUID = -6452647721513429228L;

    private RuMetodoFirmaRelacionPK ruMetodoFirmaRelacionPK;
    private boolean claveAleatoria;
    private boolean firmaUnica;
    private RuUsuario ruUsuario;
    private Servicio servicio;
    private MetodoFirma metodoFirma;

    public RuMetodoFirmaRelacion() {}

    public RuMetodoFirmaRelacion(RuMetodoFirmaRelacionPK ruMetodoFirmaRelacionPK, boolean claveAleatoria, boolean firmaUnica,
            RuUsuario ruUsuario, Servicio servicio, MetodoFirma metodoFirma) {
        this.ruMetodoFirmaRelacionPK = ruMetodoFirmaRelacionPK;
        this.claveAleatoria = claveAleatoria;
        this.firmaUnica = firmaUnica;
        this.ruUsuario = ruUsuario;
        this.servicio = servicio;
        this.metodoFirma = metodoFirma;
    }

    @EmbeddedId
    @AttributeOverrides({
        @AttributeOverride(name = "usuarioId", column = @Column(name = "USUA_X_USUA")),
        @AttributeOverride(name = "servicioId", column = @Column(name = "SERV_X_SERV")),
        @AttributeOverride(name = "metodoFirmaId", column = @Column(name = "METO_X_METO"))
    })
    public RuMetodoFirmaRelacionPK getRuMetodoFirmaRelacionPK() {
        return ruMetodoFirmaRelacionPK;
    }

    public void setRuMetodoFirmaRelacionPK(RuMetodoFirmaRelacionPK ruMetodoFirmaRelacionPK) {
        this.ruMetodoFirmaRelacionPK = ruMetodoFirmaRelacionPK;
    }

    @Column(name = "L_CLAVE_ALEATORIA", length = 1)
    @Convert(converter = BooleanSiNoConverter.class)
    public boolean isClaveAleatoria() {
        return claveAleatoria;
    }

    public void setClaveAleatoria(boolean claveAleatoria) {
        this.claveAleatoria = claveAleatoria;
    }

    @Column(name = "L_FIRMA_UNICA", length = 1)
    @Convert(converter = BooleanSiNoConverter.class)
    public boolean isFirmaUnica() {
        return firmaUnica;
    }

    public void setFirmaUnica(boolean firmaUnica) {
        this.firmaUnica = firmaUnica;
    }

    @MapsId("usuarioId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USUA_X_USUA", nullable = false)
    public RuUsuario getRuUsuario() {
        return ruUsuario;
    }

    public void setRuUsuario(RuUsuario ruUsuario) {
        this.ruUsuario = ruUsuario;
    }

    @MapsId("servicioId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SERV_X_SERV", nullable = false)
    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    @MapsId("metodoFirmaId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "METO_X_METO", nullable = false)
    public MetodoFirma getMetodoFirma() {
        return metodoFirma;
    }

    public void setMetodoFirma(MetodoFirma metodoFirma) {
        this.metodoFirma = metodoFirma;
    }

    @Override
    public String toString() {
        return "RuMetodoFirmaRelacion [ruMetodoFirmaRelacionPK=" + ruMetodoFirmaRelacionPK + ", claveAleatoria="
                + claveAleatoria + ", firmaUnica=" + firmaUnica + "]";
    }
}
