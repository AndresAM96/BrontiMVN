# Inventario Backend

Este es el backend del sistema de inventario desarrollado en **Spring Boot 3**, con persistencia en **MySQL** y gestionado por **Maven**.

## 📦 Tecnologías

- Spring Boot 3
- Spring Data JPA
- MySQL 8
- Maven

## 📜 Estructura del proyecto

- `model` → Entidades JPA
- `repository` → Interfaces JPA Repository
- `service` → Lógica de negocio
- `controller` → Controladores REST

## 🚀 Configuración

1. Crea una base de datos en MySQL:

```sql
CREATE DATABASE inventario;

Tambien de puede importar la base de datos del proyecto a MySQL.

Al importarse la base de datos se inserta un superadministrador por defecto:

```sql
-- Insertar superadministrador
INSERT INTO usuarios (cedula_usuario, nombre, contrasena, rol) VALUES
(1000000000, 'SuperAdmin', 'admin123', 'SuperAdmin');

2. Configura tus credenciales en src/main/resources/application.properties:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/inventario
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password

3. Correr el proyecto desde terminal o IDE:

```bash
./mvnw spring-boot:run

## 📦 Build

```bash
./mvnw clean package

## 🔐 Seguridad

Inicio de sesión con credenciales desde el frontend.

Control de sesión mediante token local (almacenado en localStorage del navegador).

## 📌 Notas

Se incluye manejo de relaciones con @JsonManagedReference y @JsonBackReference para evitar recursividad.

Migrado desde Gradle a Maven, utilizando spring-boot-starter-parent.