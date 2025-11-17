# Imagen base segura mantenida por Eclipse Temurin (mejor que openjdk oficial)
FROM eclipse-temurin:17-jdk-alpine

# Establece el directorio de trabajo
WORKDIR /app

# Crea usuario no root para ejecutar la app con menor privilegio
RUN addgroup -S appgroup && adduser -S appuser -G appgroup

# Copia el jar ya compilado (build hecho fuera del contenedor)
COPY target/api-administracion-servicios-publicos-0.0.1-SNAPSHOT.jar app.jar

# Asigna permisos al usuario seguro
RUN chown -R appuser:appgroup /app

# Cambia al usuario no root
USER appuser

# Ejecuta la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]