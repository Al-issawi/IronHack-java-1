# Music Library

Una pequeña aplicación web para guardar y consultar discos. La he preparado a partir del ejercicio de Java y MySQL de la carpeta `semana-5/JDBC-1/musica`, ampliándolo con una API REST y una interfaz web.

## Qué puede hacer

- Ver todos los discos guardados.
- Añadir un disco indicando título, artista y año.
- Eliminar un disco.
- Consultar un disco por su identificador y actualizarlo mediante la API.

## Tecnologías

- **Backend:** Java 21, Spring Boot, Spring Data JPA y Maven.
- **Base de datos:** MySQL (Aiven en producción).
- **Frontend:** HTML, CSS y JavaScript.
- **Despliegue previsto:** Render (API) y GitHub Pages (web).

## Estructura

```text
music-library/
├── backend/                 # API REST de Spring Boot
│   ├── Dockerfile
│   ├── pom.xml
│   └── src/main/
│       ├── java/com/alisawi/musiclibrary/
│       └── resources/application.properties
├── database/schema.sql     # Tabla y datos de ejemplo
└── frontend/               # Página estática para GitHub Pages
    ├── index.html
    ├── styles.css
    ├── config.js
    └── app.js
```

## Ejecutar en local

Necesitas Java 21, Maven y MySQL.

1. Crea una base de datos llamada `musica_db` en MySQL.
2. Ejecuta el contenido de `database/schema.sql`.
3. Abre una terminal dentro de `backend`.
4. Configura las variables de entorno y arranca Spring Boot.

En Windows PowerShell, para una instalación local de MySQL:

```powershell
$env:DB_HOST="localhost"
$env:DB_PORT="3306"
$env:DB_NAME="musica_db"
$env:DB_USER="root"
$env:DB_PASSWORD="TU_PASSWORD_LOCAL"
$env:DB_SSL_MODE="DISABLED"
$env:CORS_ALLOWED_ORIGINS="http://localhost:5500,http://127.0.0.1:5500"
mvn spring-boot:run
```

Abre `frontend/index.html` con Live Server (normalmente en el puerto 5500). La API estará en `http://localhost:8080`.

## Endpoints de la API

| Método | Ruta | Qué hace |
|---|---|---|
| GET | `/api/discos` | Lista todos los discos |
| GET | `/api/discos/{id}` | Busca un disco |
| POST | `/api/discos` | Añade un disco |
| PUT | `/api/discos/{id}` | Actualiza un disco |
| DELETE | `/api/discos/{id}` | Elimina un disco |

Ejemplo de cuerpo JSON para crear o actualizar:

```json
{
  "titulo": "Kind of Blue",
  "artista": "Miles Davis",
  "lanzamiento": 1959
}
```

## Despliegue

El despliegue se hace en tres partes. No subas contraseñas ni certificados privados al repositorio.

### 1. Base de datos en Aiven

1. Crea un servicio MySQL en Aiven.
2. Abre la consola SQL de Aiven y ejecuta `database/schema.sql`.
3. Guarda los datos de conexión que muestra Aiven: host, puerto, nombre de base de datos, usuario y contraseña.

### 2. Backend en Render

1. Crea un servicio **Web Service** desde este repositorio.
2. Selecciona la rama `deployment/music-library`.
3. Configura como **Root Directory**: `java/music-library/backend`.
4. Selecciona **Docker** como entorno.
5. Añade estas variables en la sección Environment de Render:

| Variable | Valor |
|---|---|
| `DB_HOST` | Host de Aiven |
| `DB_PORT` | Puerto de Aiven |
| `DB_NAME` | Nombre de la base de datos de Aiven |
| `DB_USER` | Usuario de Aiven |
| `DB_PASSWORD` | Contraseña de Aiven |
| `DB_SSL_MODE` | `REQUIRED` |
| `CORS_ALLOWED_ORIGINS` | URL de GitHub Pages (se configura después) |

Render proporciona la variable `PORT`; la aplicación la utiliza automáticamente. Cuando termine el despliegue, prueba `https://TU-API.onrender.com/api/discos`.

### 3. Frontend en GitHub Pages

1. Edita `frontend/config.js` y sustituye `http://localhost:8080` por la URL real de tu servicio Render, sin añadir `/api/discos`.
2. En GitHub, abre Settings → Pages.
3. En Build and deployment, elige Deploy from a branch.
4. Selecciona la rama `deployment/music-library` y la carpeta `/java/music-library/frontend` si GitHub Pages permite esa carpeta en tu configuración. Si no aparece como opción, publica el contenido de frontend desde una rama/carpeta `docs` o usa GitHub Actions.
5. Copia la URL pública que genera GitHub Pages.

### 4. Terminar CORS y comprobar

Vuelve a Render y actualiza `CORS_ALLOWED_ORIGINS` con la URL exacta de GitHub Pages (sin barra final). Guarda los cambios para que Render reinicie el servicio.

Comprueba en la web que puedes:
- Ver los discos que llegan desde Aiven.
- Añadir un disco nuevo.
- Eliminar un disco.

## Variables importantes

La configuración de conexión está en `backend/src/main/resources/application.properties`. Los valores reales se inyectan desde variables de entorno. No guardes contraseñas reales en ese archivo ni en GitHub.

## Estado del despliegue

El código y la configuración están preparados en el repositorio. Para que la aplicación quede publicada aún hay que crear/configurar los servicios de Aiven, Render y GitHub Pages con las credenciales de tu cuenta. Esos pasos requieren que inicies sesión y añadas los secretos desde tus paneles; no compartas aquí la contraseña de Aiven.
