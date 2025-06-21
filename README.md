# 🧩 cliente-service - CRUD con Spring Boot, Java 17 y H2

Este microservicio implementa un CRUD completo para gestionar clientes, usando Java 17, Spring Boot 3, JPA, H2 embebido y documentación OpenAPI (Swagger UI). Ideal para pruebas técnicas, entrevistas o como base para microservicios reales.

---

## 📌 Requisitos Previos

- Java 17+
- Maven 3.9+
- IDE como VS Code, IntelliJ o Eclipse

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

- Swagger UI: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
- Consola H2: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)  
  - JDBC URL: `jdbc:h2:mem:clientesdb`
  - Usuario: `sa`
  - Contraseña: *(dejar en blanco)*

---

## 📦 Endpoints disponibles

| Método | Endpoint                       | Descripción                        |
|--------|--------------------------------|------------------------------------|
| GET    | `/api/clientes`                | Obtener todos los clientes         |
| POST   | `/api/clientes`                | Crear un nuevo cliente             |
| PUT    | `/api/clientes/{id}`           | Actualizar cliente por ID          |
| DELETE | `/api/clientes/{id}`           | Eliminar cliente por ID            |
| GET    | `/api/clientes/{id}/beneficio` | Ver beneficio por tipo de cliente  |

---

## 🔍 Cómo probar el CRUD en Swagger

Abre en navegador:  
👉 [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

### ▶️ 1. Crear un cliente

- En `POST /api/clientes`, haz clic en "Try it out"
- Pega este JSON de ejemplo:

```json
{
  "id": "1",
  "nombre": "Juan",
  "email": "juan@email.com",
  "edad": 30,
  "tipoCliente": "VIP"
}
```

- Presiona **"Execute"**

---

### 📋 2. Consultar todos los clientes

- Ve a `GET /api/clientes`
- Haz clic en **"Try it out"** → **"Execute"**
- Verás la lista de clientes creados

---

### 🧠 3. Ver beneficio por tipo de cliente

- Usa `GET /api/clientes/{id}/beneficio`
- Escribe `1` como ID
- Verás:

```
"Cliente VIP: descuento aplicado"
```

Si el tipo es `REGULAR`, verás:

```
"Cliente REGULAR: sin descuento"
```

---

### ✏️ 4. Actualizar cliente

- En `PUT /api/clientes/{id}`, escribe el ID y el nuevo JSON:

```json
{
  "id": "1",
  "nombre": "Juan",
  "email": "juan2025@email.com",
  "edad": 30,
  "tipoCliente": "REGULAR"
}
```

---

### ❌ 5. Eliminar cliente

- Ve a `DELETE /api/clientes/{id}`
- Ingresa el ID `1` → "Execute"
- Luego prueba el GET y verás que fue eliminado

---

## ⚙️ Arquitectura

- **ClienteDTO**: `record` de Java 17 (inmutable) para requests/responses.
- **Cliente**: Entidad JPA con persistencia en H2.
- **TipoCliente**: Enum `REGULAR` / `VIP`
- **ClienteService**: Lógica de negocio, con logs y pattern matching (`switch`).
- **ClienteRepository**: Interfaz `JpaRepository` con operaciones automáticas.
- **Swagger UI**: documenta y permite probar todos los endpoints REST.

---

## 🧾 Logs

El sistema utiliza `java.util.logging` para registrar:

- Creación, actualización y eliminación de clientes
- Aplicación de beneficios por tipo de cliente

---

## 🧪 Pruebas unitarias

Puedes ejecutar las pruebas con:

```bash
mvn test
```

Se incluye una prueba de ejemplo en `ClienteServiceTest.java`

---

## 🧑‍💻 Autor

**Juan Valentín Alducin Vázquez**  
Desarrollado para evaluación técnica y portafolio profesional.
