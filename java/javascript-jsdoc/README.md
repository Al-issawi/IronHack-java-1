# Laboratorio JavaScript – JSDoc

Práctica para aprender a documentar código JavaScript y generar documentación HTML con JSDoc.

## Estructura

- `nivel-1/main.js`: variables y constantes documentadas, sin funciones.
- `nivel-2/calculadora.js`: funciones documentadas con `@param`, `@returns`, `@throws` y `@example`.
- `jsdoc.json`: configuración de JSDoc.
- `docs/`: carpeta de salida que se crea al generar la documentación.

## Requisitos

1. Instala Node.js desde https://nodejs.org/.
2. Comprueba la instalación desde la terminal:

```bash
node --version
npm --version
```

## Instalar JSDoc

Desde esta carpeta (`java/javascript-jsdoc`), ejecuta:

```bash
npm init -y
npm install --save-dev jsdoc
```

## Ejecutar los ejemplos

Para probar las funciones del segundo ejercicio:

```bash
node nivel-2/calculadora.js
```

## Generar documentación HTML

Ejecuta desde esta carpeta:

```bash
npx jsdoc -c jsdoc.json
```

JSDoc generará la documentación en la carpeta `docs/`. Abre `docs/index.html` en el navegador.

También puedes generar la documentación sin archivo de configuración:

```bash
npx jsdoc nivel-1/main.js nivel-2/calculadora.js -d docs
```

## Etiquetas JSDoc utilizadas

| Etiqueta | Para qué sirve |
| --- | --- |
| `@author` | Indica quién ha escrito el código. |
| `@since` | Indica desde qué versión existe. |
| `@version` | Versión del archivo o módulo. |
| `@type` | Describe el tipo de una variable. |
| `@constant` | Indica que una variable es constante. |
| `@param` | Documenta un parámetro de función. |
| `@returns` | Explica qué devuelve una función. |
| `@throws` | Documenta errores que puede lanzar. |
| `@example` | Incluye un ejemplo de uso. |
| `@private` | Marca un elemento como privado en la documentación. |
| `@see` | Añade una referencia relacionada. |
| `@module` | Identifica un módulo. |

## Recursos

- [Documentación oficial de JSDoc](https://jsdoc.app/about-getting-started)
- [Node.js](https://nodejs.org/)
- [Tutorial de instalación de Node.js en VS Code](https://www.solvetic.com/tutoriales/article/12465-instalar-node-js-en-visual-studio-code/)
- [Vídeo sobre JavaScript, tipos y Node.js](https://www.youtube.com/watch?v=U329pKWKqWw)

## EXTRA: tutoriales

JSDoc permite añadir tutoriales usando la etiqueta `@tutorial` y configurarlos en `jsdoc.json`. Esta práctica deja preparada la estructura básica; se puede ampliar añadiendo un fichero de tutorial y registrándolo en la configuración.

---

Ejercicio de documentación JavaScript – IronHack.
