# CGR – API Registro Servicios Publicos

**Componente backend del sistema SIAPER-RU** que provee funcionalidades mediante APIs REST para el flujo de la aplicación web-registro-servicios-publicos.

## Descripción técnica de la solución

Aplicación desarrollada con framework Spring Boot, empaquetada como un archivo JAR autoejecutable que incluye un servidor embebido. Opera como una unidad independiente del entorno de ejecución. Se incluye archivo de configuracion Dockerfile que permite construir una imagen para contenerización, permitiendo su uso en diferentes plataformas y entornos orquestados.

## Build and Run (local)
Para construir y correr la aplicación usando el wrapper de maven (no requiere maven instalado), utilizar el siguiente comando desde la raíz del proyecto:

```bash
./mvnw clean package "-Dspring.profiles.active=local"
```

```bash
./mvnw spring-boot:run "-Dspring-boot.run.profiles=local"
```

## Test unitarios
Para ejecutar los tests unitarios usando el wrapper de maven (no requiere maven instalado), utilizar el siguiente comando desde la raíz del proyecto:
```bash
./mvnw test
```
---
Instrucciones de configuración y despliegue en otros ambientes consultar **Manual instalación componente**.
