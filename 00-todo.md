# TODOs - API Framework Agnostic Java

## Seguridad

- [ ] Mover secretos (credenciales DB, URLs externas) a variables de ambiente en lugar de tenerlos hardcodeados en `application.properties`, `application.yaml` y `docker-compose.yaml`
- [ ] Eliminar `System.out.println("body: " + body)` en `infra-quarkus/.../CardRestControllerAdapter.java:33` (debug en código productivo)
- [ ] Agregar análisis de vulnerabilidades en dependencias (OWASP dependency-check o similar)

## Versionado y Dependencias

- [ ] Eliminar duplicación de versión de Spring Boot (aparece dos veces en `infra-spring-boot/pom.xml`: línea 64 y 74)
- [ ] Centralizar versiones comunes (Jackson, JUnit, AssertJ) como properties en el POM padre
- [ ] Unificar versión del Maven Wrapper entre módulos (Spring Boot usa 3.9.10, Quarkus usa 3.9.9)

## Consistencia entre Frameworks

- [ ] Unificar formato de DTOs: Spring Boot usa `card_name` y Quarkus usa `name` como JSON property — deberían ser iguales
- [ ] Corregir status HTTP en Spring Boot: `getAllCards()` retorna `CREATED` (201) en vez de `OK` (200)
- [ ] Unificar la URL base de la API externa (Scryfall) — en Spring Boot está hardcodeada en el código, en Quarkus está en anotación

## Manejo de Errores

- [ ] Reemplazar `catch (Exception e)` genérico que retorna `null` silenciosamente en ambos `ExternalClientAdapter`
- [ ] Agregar logging real (SLF4J/Log4j) en lugar de `System.out.println`
- [ ] Agregar validación de entrada en `saveCard(String name)` — actualmente acepta null/vacío sin validar
- [ ] Manejar el caso donde `getValidatedCardName()` retorna null antes de guardar

## Testing

- [ ] Agregar tests unitarios para `CardService` en el módulo `core`
- [ ] Agregar tests para los adapters de Spring Boot (controller, repository, external client)
- [ ] Agregar tests para los adapters de Quarkus (tiene JUnit5 y REST Assured configurados pero sin tests)
- [ ] Agregar tests de integración para los endpoints REST

## CI/CD

- [ ] Crear pipeline de CI (GitHub Actions, GitLab CI, etc.) con build, test y análisis estático
- [ ] Agregar linting / análisis estático (Checkstyle, SpotBugs, etc.)

## Docker y Despliegue

- [ ] Corregir mismatch de puertos: Dockerfiles de Quarkus exponen 8080 pero la app corre en 8001
- [ ] Crear Dockerfile para el módulo Spring Boot
- [ ] Agregar servicios de las apps al `docker-compose.yaml` (actualmente solo tiene PostgreSQL)
- [ ] Agregar volumen persistente para PostgreSQL en docker-compose
- [ ] Agregar health checks en docker-compose
- [ ] Parametrizar credenciales en docker-compose con variables de ambiente / `.env`

## API y Documentación

- [ ] Agregar documentación OpenAPI/Swagger a ambos frameworks
- [ ] Agregar validación de request con Jakarta Validation (JSR-380)
- [ ] Agregar header `Location` en respuestas POST que retornan 201
- [ ] Mejorar el README con guía de setup, arquitectura y uso
- [ ] Documentar esquema de base de datos

## Arquitectura

- [ ] Renombrar `saveCard` en el use case port a algo más explícito como `validateAndSaveCard`, ya que internamente llama a una API externa antes de guardar — el nombre actual esconde ese comportamiento
- [ ] Agregar excepción de dominio (ej: `CardNotFoundException`) cuando la API externa no encuentra la carta, en vez de guardar `null` silenciosamente en la DB
- [ ] Definir estrategia de versionado de API (v1, v2, etc.)
