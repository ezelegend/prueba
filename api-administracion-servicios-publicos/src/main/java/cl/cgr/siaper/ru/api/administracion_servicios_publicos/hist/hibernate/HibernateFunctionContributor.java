package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.hibernate;

import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.spi.MetadataBuilderContributor;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StandardBasicTypes;

public class HibernateFunctionContributor implements MetadataBuilderContributor {

    @Override
    public void contribute(MetadataBuilder metadataBuilder) {
        metadataBuilder.applySqlFunction(
            "esVersionActual", 
            new StandardSQLFunction("esVersionActual", StandardBasicTypes.INTEGER)
        );
    }
}