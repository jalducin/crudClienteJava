# 🧩 cliente-service - CRUD con Spring Boot, Java 17 y H2

Este microservicio implementa un CRUD completo para gestionar clientes, usando Java 17, Spring Boot 3, JPA, H2 embebido y documentación OpenAPI (Swagger UI). Ideal para pruebas técnicas, entrevistas o como base para microservicios reales.

---

```bash
crudClienteJava/
├── .gitignore
├── pom.xml
├── README.md
├── src
│   ├── main
│   │   ├── java
│   │   │   └── org
│   │   │       └── alducin
│   │   │           └── clientes
│   │   │               ├── Cliente.java
│   │   │               ├── ClienteController.java
│   │   │               ├── ClienteDTO.java
│   │   │               ├── ClienteRepository.java
│   │   │               ├── ClienteService.java
│   │   │               ├── ClienteServiceApp.java
│   │   │               ├── TipoCliente.java
│   │   │               ├── config
│   │   │               │   └── SecurityConfig.java
│   │   │               ├── LogEntry.java
│   │   │               ├── LogEntryRepository.java
│   │   │               └── LogService.java
│   │   └── resources
│   │       └── application.properties
│   └── test
│       └── java
│           └── org
│               └── alducin
│                   └── clientes
│                       └── ClienteControllerTest.java
```

* **`src/main/java/...`** contiene toda la lógica de tu microservicio (entidades, repositorios, servicios, controladores y configuración).
* **`src/main/resources/application.properties`** tiene la configuración de H2, JPA, Swagger y seguridad.
* **`src/test/java/...`** alberga tu prueba de integración con MockMvc y unitarias.
* **`pom.xml`** gestiona todas tus dependencias (Spring Boot, JPA, H2, Lombok, Swagger, Test, Security).
* **`.gitignore`** debe incluir al menos:

  ```gitignore
  /target/
  *.class
  ```

---

## 📌 Requisitos Previos

* Java 17+
* Maven 3.9+
* IDE como VS Code, IntelliJ o Eclipse

---

## 🚀 Instalación y ejecución

1. Clona el proyecto:

   ```bash
   git clone https://github.com/tuusuario/cliente-service.git
   cd cliente-service
   ```

2. Compila y ejecuta:

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

3. Accede desde navegador:

   * **Swagger UI** (interfaz interactiva):
     [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
   * **OpenAPI YAML** (contrato de la API, versión OpenAPI 3.0):
     [http://localhost:8080/v3/api-docs.yaml](http://localhost:8080/v3/api-docs.yaml)
   * **Consola H2**:
     [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

     * JDBC URL: `jdbc:h2:mem:clientesdb`
     * Usuario: `sa`
     * Contraseña: *(dejar en blanco)*

---

## 📦 Endpoints disponibles

| Método | Endpoint                       | Descripción                       |
| ------ | ------------------------------ | --------------------------------- |
| GET    | `/api/clientes`                | Obtener todos los clientes        |
| POST   | `/api/clientes`                | Crear un nuevo cliente            |
| PUT    | `/api/clientes/{id}`           | Actualizar cliente por ID         |
| DELETE | `/api/clientes/{id}`           | Eliminar cliente por ID           |
| GET    | `/api/clientes/{id}/beneficio` | Ver beneficio por tipo de cliente |

---

## 🔍 Cómo probar el CRUD en Swagger UI

1. Abre en el navegador:
   [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

2. **Crear un cliente** (`POST /api/clientes`):

   * Haz clic en "Try it out"
   * Pega este JSON de ejemplo:

     ```json
     {
       "id": "1",
       "nombre": "Juan",
       "email": "juan@email.com",
       "edad": 30,
       "tipoCliente": "VIP"
     }
     ```
   * Presiona **Execute**

3. **Listar clientes** (`GET /api/clientes`):

   * Try it out → Execute

4. **Ver beneficio** (`GET /api/clientes/{id}/beneficio`):

   * Rellena `id` con `1` → Execute
   * Verás:

     ```
     "Cliente VIP: descuento aplicado"
     ```

5. **Actualizar cliente** (`PUT /api/clientes/{id}`):

   * Rellena `id` = `1` y el cuerpo JSON con los nuevos datos

6. **Eliminar cliente** (`DELETE /api/clientes/{id}`):

   * Rellena `id` = `1` → Execute

---

## 🧾 Pruebas Unitarias y de Integración

* **Ejecutar todas las pruebas** (unitarias e integración con MockMvc):

  ```bash
  mvn test
  ```
* La clase de ejemplo `ClienteControllerTest.java` usa `@SpringBootTest` y `@AutoConfigureMockMvc` con `@WithMockUser` para bypass de seguridad.

---

## ⚙️ Arquitectura

* **ClienteDTO**: `record` de Java 17 (inmutable) para requests/responses.
* **Cliente**: Entidad JPA con persistencia en H2.
* **TipoCliente**: Enum `REGULAR` / `VIP`.
* **ClienteService**: Lógica de negocio, con logs y pattern matching (comentario de ejemplo).
* **LogEntry & LogService**: Guarda logs de nivel INFO/ERROR en la BD.
* **Swagger/OpenAPI**: documenta y permite probar todos los endpoints REST.
* **SecurityConfig**: Configuración de Spring Security donde se permite `/api/clientes/**` y `/h2-console/**`.

---

## 🔗 Contrato OpenAPI 2.0 (YAML)

En `src/main/resources/openapi.yaml` se encuentra un contrato compatible con OpenAPI 2.0. También puedes acceder desde:

```
GET http://localhost:8080/v2/api-docs
```

---

## 🧑‍💻 Autor

**Juan Valentín Alducin Vázquez**
Desarrollado para evaluación técnica y portafolio profesional.
