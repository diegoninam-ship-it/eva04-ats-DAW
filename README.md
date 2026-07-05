# Sistema de Gestión de Reclutamiento (ATS)

Sistema de microservicios desarrollado con Spring Boot para la gestión de vacantes,
postulantes y procesos de selección.

## Arquitectura

- **config-server** (8888) — Configuración centralizada
- **eureka-server** (8761) — Registro y descubrimiento de servicios
- **api-gateway** (8080) — Punto de entrada único
- **usuario-service** (8083) — Gestión de usuarios y autenticación
- **vacante-service** (8081) — CRUD de vacantes
- **postulacion-service** (8082) — Gestión de postulaciones con Circuit Breaker y Retry

## Tecnologías

- Java 21
- Spring Boot 3.5.x
- Spring Cloud 2025.0.3
- Spring Cloud Gateway
- Spring Cloud Config
- Netflix Eureka
- OpenFeign
- Resilience4j (Circuit Breaker, Retry)
- MySQL 8
- Maven

## Orden de arranque

1. config-server
2. eureka-server
3. api-gateway
4. usuario-service
5. vacante-service
6. postulacion-service

## Base de datos

Ejecutar el script `script_bd_ats.sql` incluido en la carpeta `/sql` antes de
levantar los microservicios por primera vez.

## Documentación de pruebas

La colección de Postman se encuentra en `/postman/coleccion_ats.json`.