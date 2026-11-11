# Fetch - BD coches

Front-end para consultar y visualizar los coches almacenados en MySQL a través de una API Spring Boot.

## Requisitos
- MySQL / MySQL Workbench activo en el puerto **3306**.
- Aplicación Spring Boot en el puerto **8080**.
- VS Code con Live Server (normalmente puerto **5500**).

## Cómo ejecutarlo
1. Abre MySQL Workbench y comprueba que el servidor y la base de datos están activos.
2. Ejecuta el proyecto Spring Boot.
3. En el controlador REST de coches, permite CORS para el origen del front-end:

   ```java
   import org.springframework.web.bind.annotation.CrossOrigin;

   @CrossOrigin(origins = "*")
   @RestController
   public class CocheController {
       // Endpoints...
   }
   ```

   Para una aplicación real es mejor limitar los orígenes al necesario, por ejemplo `http://127.0.0.1:5500`.

4. Abre esta carpeta en VS Code y ejecuta `index.html` con Live Server.
5. La página consulta por defecto `GET http://localhost:8080/coches`.

## Endpoint y respuesta
Si tu controlador usa otra ruta, cambia `API_URL` al principio de `app.js` (por ejemplo `http://localhost:8080/api/coches`).
La respuesta esperada es un array JSON de coches. También se aceptan arrays dentro de `content`, `coches` o `data`.

## Qué incluye
- Fetch del listado y mensajes de carga, conexión, error y lista vacía.
- `console.log` de todos los coches y del primer coche recibido.
- Tarjetas generadas dinámicamente con los datos de cada coche.
- Búsqueda por marca, modelo, año, color, combustible e ID.
- Ordenación por marca, modelo y precio.
- Ficha de detalle al seleccionar un coche.
- Diseño adaptable a móvil y escritorio.

## Prueba de un coche individual
Ajusta la ruta y el identificador a los endpoints de tu controlador:

```js
fetch("http://localhost:8080/coches/1")
  .then(response => {
    if (!response.ok) throw new Error(response.status);
    return response.json();
  })
  .then(coche => console.log("Coche recibido:", coche))
  .catch(error => console.error("Error:", error));
```

> **Nota:** el repositorio contiene el enunciado y el ZIP del proyecto, pero no el controlador Spring descomprimido. Por eso `/coches` es la ruta inicial de configuración. Comprueba que coincide con el mapping real de tu controlador.
