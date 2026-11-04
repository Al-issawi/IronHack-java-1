# Music Library

Una pequeña aplicación web para guardar y consultar discos. Parte del ejercicio de Java y MySQL de `semana-5/JDBC-1/musica`, ampliado con una API REST y una interfaz web.

## Qué puedes hacer

- Ver todos los discos guardados.
- Añadir un disco con su título, artista y año.
- Eliminar un disco.
- Consultar y actualizar un disco mediante la API REST.

## Tecnologías

- **Backend:** Java 21, Spring Boot, Spring Data JPA y Maven.
- **Base de datos:** MySQL (Aiven en producción).
- **Frontend:** HTML, CSS y JavaScript.
- **Despliegue:** Render para la API y GitHub Pages para la web.

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
└── frontend/               # Página estática
    ├── index.html
    ├── styles.css
    ├── config.js
    └── app.js
```

## Ejecutar en local

Necesitas Java 21, Maven y MySQL.

1. Crea una base de datos llamada `musica_db`.
2. Ejecuta `database/schema.sql` en esa base de datos.
3. Abre una terminal dentro de `backend`.
4. En Windows PowerShell, configura las variables y arranca Spring Boot:

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

## Endpoints

| Método | Ruta | Función |
|---|---|---|
| GET | `/api/discos` | Lista todos los discos |
| GET | `/api/discos/{id}` | Busca un disco por ID |
| POST | `/api/discos` | Añade un disco |
| PUT | `/api/discos/{id}` | Actualiza un disco |
| DELETE | `/api/discos/{id}` | Elimina un disco |

Ejemplo de JSON para crear o actualizar:

```json
{
  "titulo": "Kind of Blue",
  "artista": "Miles Davis",
  "lanzamiento": 1959
}
```

## Despliegue

No guardes contraseñas, certificados privados ni otros secretos en el repositorio.

### 1. MySQL en Aiven

1. Crea un servicio MySQL en Aiven.
2. Abre la consola SQL de Aiven y ejecuta el contenido de `database/schema.sql` en la base de datos que vayas a utilizar.
3. Guarda los datos de conexión que muestra Aiven: host, puerto, nombre de la base de datos, usuario y contraseña.

### 2. Backend en Render

1. Crea un **Web Service** desde este repositorio.
2. Selecciona la rama `deployment/music-library`.
3. Indica `java/music-library/backend` como **Root Directory**.
4. Selecciona **Docker** como entorno.
5. Añade estas variables en la sección **Environment** de Render:

| Variable | Valor |
|---|---|
| `DB_HOST` | Host de Aiven |
| `DB_PORT` | Puerto de Aiven |
| `DB_NAME` | Nombre de la base de datos |
| `DB_USER` | Usuario de Aiven |
| `DB_PASSWORD` | Contraseña de Aiven |
| `DB_SSL_MODE` | `REQUIRED` |
| `CORS_ALLOWED_ORIGINS` | `http://localhost:5500` temporalmente |

Render define `PORT`; Spring Boot lo utiliza automáticamente. Cuando el servicio esté desplegado, comprueba la API abriendo `https://TU-API.onrender.com/api/discos`. Debe devolver una lista JSON.

### 3. Frontend en GitHub Pages

El repositorio ya incluye un workflow en `.github/workflows/deploy-music-library-pages.yml` que publica únicamente la carpeta del frontend.

1. Abre `java/music-library/frontend/config.js` y cambia `http://localhost:8080` por la URL real de Render, por ejemplo `https://nombre-de-tu-api.onrender.com`. No añadas `/api/discos` al final.
2. En GitHub, entra en **Settings → Pages**.
3. En **Build and deployment → Source**, selecciona **GitHub Actions**.
4. Abre la pestaña **Actions** y comprueba que se ejecuta el workflow **Publish Music Library frontend**. Si no se inicia automáticamente, ejecútalo con **Run workflow**.
5. Cuando termine correctamente, GitHub mostrará la URL pública de Pages.

### 4. Configurar CORS y probar

1. Copia la URL exacta de GitHub Pages.
2. En Render, cambia `CORS_ALLOWED_ORIGINS` por esa URL (sin barra final).
3. Guarda los cambios y espera a que Render reinicie el backend.
4. Abre la web y prueba listar, añadir y eliminar discos.

## Variables y seguridad

La configuración está en `backend/src/main/resources/application.properties`. Los datos reales se leen de variables de entorno. No escribas contraseñas reales en ese archivo ni las subas a GitHub.

## Estado del proyecto

El código, el frontend y los archivos de despliegue están preparados en esta rama. La aplicación todavía no está publicada: faltan crear los servicios en Aiven y Render, configurar GitHub Pages y añadir los datos privados de conexión desde los paneles de cada servicio. Esos pasos requieren acceso a tus cuentas. No compartas aquí tu contraseña de Aiven.
