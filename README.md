# Eureka Service Demo

Proyecto demo de **service discovery** con Spring Cloud Netflix Eureka. Demuestra cómo montar un registry central y dos microservicios que se descubren entre sí.

## Arquitectura

```
ServiceA (8081) ──registra──> EurekaServer (8761)
ServiceB (8082) ──registra──> EurekaServer (8761)

Cliente → GET http://localhost:8082/
  → ServiceB consulta Eureka por "ServiceA"
  → RestClient llama a ServiceA/helloWorld
  → "Hello world from Service A!"
```

| Módulo | Puerto | Descripción |
|--------|--------|-------------|
| **EurekaServer** | 8761 | Registry central (`@EnableEurekaServer`) |
| **ServiceA** | 8081 | Microservicio que expone `GET /helloWorld` |
| **ServiceB** | 8082 | Microservicio que descubre ServiceA vía Eureka y lo consume |

## Stack

- Java 21
- Spring Boot 4.1.0
- Spring Cloud 2025.1.2
- Netflix Eureka (Server + Client)
- Spring Web MVC + RestClient
- Maven (multi-module)

## Ejecución

Requiere Java 21 instalado.

```bash
# 1.Levantar el servidor Eureka
./EurekaServer/mvnw spring-boot:run -f EurekaServer/pom.xml

# 2.Levantar ServiceA
./ServiceA/mvnw spring-boot:run -f ServiceA/pom.xml

# 3.Levantar ServiceB
./ServiceB/mvnw spring-boot:run -f ServiceB/pom.xml
```

Una vez todo corriendo, visitar `http://localhost:8082/` para ver la comunicación entre servicios.
