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
├── src/
│   ├── main/
│   │   ├── java/com/gamestore/
│   │   │   ├── controller/
│   │   │   ├── model/
│   │   │   └── repository/
│   │   └── resources/
│   │       ├── templates/
│   │       └── static/
│   │           ├── css/
│   │           └── img/
│   └── test/
│       └── java/com/gamestore/
└── README.md
```

## Estado del proyecto

🚧 Fase 1 — Propuesta y diseño completada. Documento de diseño disponible en este repositorio.

## Cómo ejecutar (próximas fases)

```bash
mvn spring-boot:run
```

---
© 2026 GameStore — Héctor Guamán & Uriel Acosta — Unidad 4
