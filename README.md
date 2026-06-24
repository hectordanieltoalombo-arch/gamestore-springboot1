# GameStore — Tienda de Videojuegos

Proyecto de la Unidad 4: Desarrollo de Consultas Interactivas.

## Integrantes

| Nombre | Rol |
|---|---|
| Héctor Guamán | Backend / Base de datos |
| Uriel Acosta | Frontend / Controladores |

## Descripción

GameStore es una aplicación web para la venta de videojuegos. Permite explorar un catálogo filtrable por género y plataforma, buscar títulos por nombre y visualizar precio y disponibilidad de cada juego.

## Tecnologías

- Java 17
- Spring Boot 3.3
- Spring Data JPA
- Thymeleaf
- PostgreSQL
- Maven
- Bootstrap 5

## Estructura del proyecto

```
gamestore-springboot/
├── pom.xml
├── mvnw.cmd
├── .mvn/
├── src/
│   ├── main/
│   │   ├── java/com/gamestore/
│   │   │   ├── GamestoreApplication.java
│   │   │   ├── controller/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   └── config/
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── templates/
│   │       └── static/
│   │           ├── css/
│   │           └── img/
│   └── test/
│       └── java/com/gamestore/
└── README.md
```

## Estado del proyecto

✅ Fase 1 — Propuesta y diseño completada. Documento de diseño disponible en este repositorio.

✅ Fase 2 — Desarrollo (avance funcional):
- Catálogo de videojuegos interactivo con filtros por género y plataforma.
- Búsqueda de juegos por nombre.
- Paginación de resultados (8 juegos por página).
- Carga automática de datos de prueba (15 videojuegos) al iniciar la aplicación.
- Aplicación verificada funcionando localmente en `http://localhost:8080`.
- Log de Claude Code con prompts documentados disponible en este repositorio.

## Modelo de datos (PostgreSQL)

| Tabla | Campos principales |
|---|---|
| usuarios | id, nombre, email, contrasena, rol |
| videojuegos | id, titulo, descripcion, precio, imagen_url, stock, id_genero, id_plataforma |
| generos | id, nombre |
| plataformas | id, nombre |

## Cómo ejecutar

1. Crear la base de datos vacía en PostgreSQL (una sola vez):
   ```sql
   CREATE DATABASE gamestore_db;
   ```
2. Ajustar usuario/contraseña en `src/main/resources/application.properties` si es necesario.
3. Ejecutar la aplicación (no requiere Maven instalado, usa el wrapper incluido):
   ```bash
   .\mvnw.cmd spring-boot:run
   ```
4. Abrir en el navegador:
   - Inicio: `http://localhost:8080`
   - Catálogo: `http://localhost:8080/catalogo`

Las tablas y los datos de prueba se crean automáticamente al iniciar la aplicación por primera vez.

---
© 2026 GameStore — Héctor Guamán & Uriel Acosta — Unidad 4
