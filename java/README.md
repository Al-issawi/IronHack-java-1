# Java – ejercicios y prácticas

Este directorio reúne los ejercicios que voy haciendo durante la formación de Java en Ironhack. Está organizado por semanas para que sea fácil encontrar cada práctica y volver a ella cuando necesite repasar algún concepto.

No es una única aplicación: son ejercicios y proyectos pequeños que trabajan distintas partes de Java, desde los primeros programas hasta el acceso a bases de datos.

## Contenido

| Carpeta | Qué encontrarás |
| --- | --- |
| `semana-1` | Primeros ejercicios de Java y prácticas iniciales. |
| `semana-2` | Métodos, objetos, ArrayList, modelos y herencia. Incluye ejercicios de bicicletas, discos, juguetes y zapatería, entre otros. |
| `semana-3` | Prácticas con miembros `static`, descuentos y pequeños ejercicios de programación. |
| `semana-4-Database` | Trabajo con bases de datos y SQL: creación de tablas, consultas, relaciones y ejercicios relacionados con JPA. |
| `semana-5` | Primeras prácticas de JDBC. Incluye un pequeño programa de consola para insertar y consultar discos en MySQL. |
| `javadoc` | Ejercicios de documentación con Javadoc y el HTML generado para dos prácticas. |

## Tecnologías y herramientas que aparecen

- Java (el ejercicio JDBC de la carpeta `semana-5/JDBC-1/musica` está configurado para Java 21).
- Maven, en ese mismo ejercicio JDBC.
- MySQL y SQL.
- JDBC y `PreparedStatement` para ejecutar consultas con parámetros.
- Javadoc para generar documentación del código.

Cada práctica puede tener sus propios requisitos. Consulta los archivos del proyecto correspondiente antes de ejecutarlo.

## Ejecutar el ejercicio JDBC de música

El proyecto está en:

```text
semana-5/JDBC-1/musica
```

Necesitas tener instalado Java 21 y Maven, además de un servidor MySQL accesible.

### 1. Preparar la base de datos

El script SQL de creación está en:

```text
semana-4-Database/Database/musica_db.sql
```

Ejecuta ese script en MySQL. Crea la base de datos `musica_db` y la tabla `discos`, que utiliza el programa.

### 2. Revisar la conexión

Antes de ejecutar el programa, revisa la configuración de conexión en:

```text
semana-5/JDBC-1/musica/src/main/java/Main.java
```

La versión actual está preparada para una base de datos MySQL local en `localhost:3306`, con el usuario `root`. La contraseña que aparece en el código es un valor de ejemplo del ejercicio: cámbiala por la tuya antes de ejecutarlo.

**Importante:** no subas contraseñas reales al repositorio. Para una versión que se vaya a compartir o desplegar, guarda las credenciales fuera del código, por ejemplo en variables de entorno.

### 3. Compilar y ejecutar

Abre una terminal dentro de la carpeta `musica` y ejecuta:

```bash
mvn clean compile
mvn exec:java -Dexec.mainClass=Main
```

Si Maven indica que no encuentra el plugin `exec`, puedes ejecutar la clase desde IntelliJ IDEA o configurar el plugin correspondiente en el `pom.xml`.

El programa pide el título, el artista y el año de lanzamiento. Después inserta el disco y muestra los registros guardados en la tabla.

## Documentación Javadoc

La carpeta `javadoc` contiene dos prácticas:

- `nivel-1-viajes`: documentación de una clase para planificar un viaje.
- `nivel-2-zapateria`: documentación de varias clases relacionadas con una zapatería y distintos tipos de zapatos.

En `javadoc/README.md` están los pasos para generar de nuevo la documentación desde Visual Studio Code.

## Estado del repositorio

Este repositorio es un cuaderno de prácticas de Java. En el contenido revisado para este README no aparece todavía una aplicación web completa con frontend, API backend y base de datos desplegable como una sola solución.

Por eso, este README describe lo que hay ahora mismo y no presenta los ejercicios como si ya estuvieran publicados online. Para la práctica de despliegue habrá que elegir o preparar una aplicación concreta que reúna esas tres partes.

---

*Repositorio de aprendizaje personal. Los ejercicios pueden evolucionar a medida que avance la formación.*
