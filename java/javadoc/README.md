# Laboratorio de Javadoc

Este laboratorio contiene los dos niveles pedidos en el enunciado. Cada nivel incluye el codigo fuente en `src` y la documentacion HTML generada en `docu`.

## Nivel 1: una clase

`nivel-1-viajes/src/PlanificadorViaje.java` documenta una clase sencilla para describir un viaje y calcular su presupuesto estimado.

## Nivel 2: varias clases

`nivel-2-zapateria/src` contiene una clase abstracta `Zapato`, tres tipos concretos y una clase `ZapateriaApp` que los muestra en uso.

## Generar o actualizar la documentacion desde VS Code

1. Instala la extension **Javadoc Tools** desde Extensions (`Ctrl+Shift+X`).
2. Abre en VS Code la carpeta del nivel que quieres documentar: `nivel-1-viajes` o `nivel-2-zapateria`.
3. En Settings de VS Code, busca `javadoc-tools.generateJavadoc.targetFolder` y establece `${WorkspaceRoot}/docu` como carpeta de salida.
4. Abre la paleta de comandos con `Ctrl+Shift+P`.
5. Ejecuta **Javadoc Tools: Export Javadoc**.
6. Abre el archivo `docu/index.html` de ese nivel en un navegador para consultar la documentacion.

Repite los pasos para el otro nivel si tambien quieres regenerar su documentacion. La extension exporta los comentarios Javadoc que ya estan escritos en el codigo. Si modificas un comentario o la API, guarda el archivo antes de exportar.

Para generar comentarios nuevos en el codigo, la extension tambien ofrece los comandos **Javadoc Tools: Generate Javadoc Comments for Open File** y **Javadoc Tools: Generate Javadoc Comments for Workspace**. Revisa y guarda los comentarios generados antes de exportar el HTML.

Los comentarios usan etiquetas Javadoc como `@param`, `@return`, `@see` y `{@link ...}`, junto con formato HTML sencillo.

