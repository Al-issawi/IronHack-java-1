/**
 * Calculadora de presupuesto de viaje.
 *
 * Ejemplo de documentación de funciones con parámetros, valores de retorno,
 * excepciones y ejemplos de uso.
 *
 * @author Mohammed Alisawi
 * @since 2026-11-12
 * @version 1.0.0
 * @see https://jsdoc.app/
 * @module nivel-2/calculadora
 */

/**
 * Calcula el coste total de un viaje.
 *
 * @param {number} presupuestoDiario - Coste estimado por día, en euros.
 * @param {number} numeroDias - Duración del viaje en días.
 * @returns {number} Presupuesto total del viaje.
 * @throws {TypeError} Si alguno de los argumentos no es numérico.
 * @throws {RangeError} Si los valores son negativos o los días no son válidos.
 * @example
 * calcularPresupuesto(60, 4); // 240
 */
function calcularPresupuesto(presupuestoDiario, numeroDias) {
    validarNumero(presupuestoDiario, "presupuestoDiario");
    validarNumero(numeroDias, "numeroDias");

    if (presupuestoDiario < 0 || !Number.isInteger(numeroDias) || numeroDias <= 0) {
        throw new RangeError("El presupuesto debe ser positivo y los días un entero mayor que cero.");
    }

    return presupuestoDiario * numeroDias;
}

/**
 * Añade un gasto al presupuesto acumulado.
 *
 * @param {number} totalActual - Cantidad acumulada hasta ahora.
 * @param {number} nuevoGasto - Importe que se quiere añadir.
 * @returns {number} Nuevo total después de añadir el gasto.
 * @throws {TypeError} Si algún argumento no es numérico.
 * @throws {RangeError} Si alguno de los importes es negativo.
 * @example
 * agregarGasto(100, 25); // 125
 */
function agregarGasto(totalActual, nuevoGasto) {
    validarNumero(totalActual, "totalActual");
    validarNumero(nuevoGasto, "nuevoGasto");

    if (totalActual < 0 || nuevoGasto < 0) {
        throw new RangeError("Los importes no pueden ser negativos.");
    }

    return totalActual + nuevoGasto;
}

/**
 * Calcula cuánto presupuesto queda disponible.
 *
 * @param {number} presupuesto - Presupuesto total disponible.
 * @param {number} gastado - Cantidad que ya se ha gastado.
 * @returns {number} Dinero restante. Puede ser negativo si se supera el presupuesto.
 * @throws {TypeError} Si algún argumento no es numérico.
 * @example
 * calcularRestante(500, 320); // 180
 */
function calcularRestante(presupuesto, gastado) {
    validarNumero(presupuesto, "presupuesto");
    validarNumero(gastado, "gastado");

    return presupuesto - gastado;
}

/**
 * Calcula el porcentaje utilizado del presupuesto.
 *
 * @param {number} presupuesto - Presupuesto total disponible.
 * @param {number} gastado - Cantidad gastada.
 * @returns {number} Porcentaje gastado, redondeado a dos decimales.
 * @throws {TypeError} Si algún argumento no es numérico.
 * @throws {RangeError} Si el presupuesto es igual o menor que cero o el gasto es negativo.
 * @example
 * calcularPorcentaje(400, 100); // 25
 */
function calcularPorcentaje(presupuesto, gastado) {
    validarNumero(presupuesto, "presupuesto");
    validarNumero(gastado, "gastado");

    if (presupuesto <= 0 || gastado < 0) {
        throw new RangeError("El presupuesto debe ser mayor que cero y el gasto no puede ser negativo.");
    }

    return Number(((gastado / presupuesto) * 100).toFixed(2));
}

/**
 * Comprueba que un valor sea un número finito.
 *
 * @private
 * @param {number} valor - Valor que se quiere comprobar.
 * @param {string} nombre - Nombre del argumento para mostrar en el error.
 * @returns {void} No devuelve ningún valor.
 * @throws {TypeError} Si el valor no es un número finito.
 */
function validarNumero(valor, nombre) {
    if (typeof valor !== "number" || !Number.isFinite(valor)) {
        throw new TypeError(`${nombre} debe ser un número finito.`);
    }
}

// Ejemplos de ejecución en consola.
console.log("Presupuesto:", calcularPresupuesto(60, 4), "€");
console.log("Total con gastos:", agregarGasto(240, 35), "€");
console.log("Restante:", calcularRestante(300, 125), "€");
console.log("Porcentaje gastado:", calcularPorcentaje(300, 125), "%");
