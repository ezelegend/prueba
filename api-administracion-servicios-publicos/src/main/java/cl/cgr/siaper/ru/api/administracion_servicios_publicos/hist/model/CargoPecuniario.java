package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model;

import static jakarta.persistence.GenerationType.SEQUENCE;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;

import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.converter.BooleanSiNoConverter;

@Entity
@Audited
@Table(name = "TRA_CARGO_PECUNIARIO", uniqueConstraints = @UniqueConstraint(columnNames = "X_PECU"))
public class CargoPecuniario implements java.io.Serializable {
	
	private static final long serialVersionUID = 5562233095280495494L;
	
	private Long id;
	private String codCodigo;
	private Boolean activo;
	
	public CargoPecuniario() {
	}
	
	@Id
	@SequenceGenerator(allocationSize = 1, name = "generator", sequenceName = "TRA_S_PECU_X_PECU")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "X_PECU", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "P_C_CODIGO", unique = true, nullable = false, length = 20)
	public String getCodCodigo() {
		return this.codCodigo;
	}

	public void setCodCodigo(String codCodigo) {
		this.codCodigo = codCodigo;
	}
	
	@Column(name = "P_L_ACTIVO", length = 1)
	@Convert(converter = BooleanSiNoConverter.class)
	public Boolean getActivo() {
		return this.activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CargoPecuniario))
			return false;
		CargoPecuniario castOther = (CargoPecuniario) other;
		return this.getId() != null && castOther.getId() != null && this.getId().equals(castOther.getId());
	}
}
