# Instrucciones — Fase 2

## 1. Copiar archivos a tu carpeta existente

Copia el contenido de este zip **dentro** de tu carpeta `gamestore-springboot` (la que ya tienes conectada a GitHub), respetando las rutas. Si te pregunta si quieres reemplazar carpetas, dile que sí (son las mismas rutas vacías que ya tenías).

Al terminar, tu `src/` debe quedar así:

```
src/
├── main/
│   ├── java/com/gamestore/
│   │   ├── GamestoreApplication.java
│   │   ├── model/
│   │   │   ├── Genero.java
│   │   │   ├── Plataforma.java
│   │   │   ├── Videojuego.java
│   │   │   └── Usuario.java
│   │   ├── repository/
│   │   │   ├── VideojuegoRepository.java
│   │   │   ├── GeneroRepository.java
│   │   │   ├── PlataformaRepository.java
│   │   │   └── UsuarioRepository.java
│   │   ├── controller/
│   │   │   └── HomeController.java
│   │   └── config/
│   │       └── DataLoader.java
│   └── resources/
│       ├── application.properties
│       ├── templates/
│       │   ├── index.html
│       │   └── catalogo.html
│       └── static/css/style.css
```

## 2. Único paso manual de base de datos (no es pgAdmin, es un comando)

Spring Boot va a crear las TABLAS y los DATOS solo. Pero Postgres necesita que la
base de datos `gamestore_db` exista de antemano (esto no se puede automatizar
desde Java). Hazlo una sola vez, con uno de estos métodos:

**Opción A — pgAdmin (solo para crear la base vacía, nada más):**
Click derecho en "Databases" → Create → Database → nombre: `gamestore_db` → Save.

**Opción B — línea de comandos (sin abrir pgAdmin):**
```bash
psql -U postgres -c "CREATE DATABASE gamestore_db;"
```

Después de esto, **todo lo demás es automático**: al correr la app, Spring Boot
crea las 4 tablas y las llena con 15 videojuegos de prueba la primera vez que
arranca.

## 3. Revisar credenciales

Abre `src/main/resources/application.properties` y ajusta usuario/contraseña
de PostgreSQL si son distintos a `postgres` / `123456789`.

## 4. Ejecutar el proyecto

```bash
mvn spring-boot:run
```

Abre `http://localhost:8080` — vas a ver la página de inicio con géneros,
y en `/catalogo` el catálogo con filtros por género/plataforma, búsqueda por
nombre y paginación de 8 juegos por página.

## 5. Subir a GitHub

Con GitHub Desktop: vas a ver los archivos nuevos en "Changes" → escribe un
mensaje de commit (ej. "Fase 2: catálogo interactivo con filtros y paginación")
→ Commit to main → Push origin.
