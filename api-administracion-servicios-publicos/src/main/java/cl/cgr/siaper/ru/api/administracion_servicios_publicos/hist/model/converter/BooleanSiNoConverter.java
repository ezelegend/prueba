package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false) // o true si quieres aplicar globalmente
public class BooleanSiNoConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean value) {
        if (value == null) return null;
        return value ? "S" : "N";
    }

    @Override
    public Boolean convertToEntityAttribute(String value) {
        if (value == null) return null;
        return value.equalsIgnoreCase("S");
    }
}