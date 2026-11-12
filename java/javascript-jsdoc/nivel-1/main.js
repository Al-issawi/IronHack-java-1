/**
 * Datos generales de una pequeña aplicación de viajes.
 *
 * Este archivo contiene únicamente constantes y variables, sin funciones.
 *
 * @author Mohammed Alisawi
 * @since 2026-11-12
 * @version 1.0.0
 * @see https://jsdoc.app/
 * @link https://github.com/Al-issawi/IronHack-java-1
 * @module nivel-1/main
 */

/**
 * Nombre de la aplicación.
 * @type {string}
 * @constant
 */
const APP_NAME = "Planificador de viajes";

/**
 * Versión actual de la aplicación.
 * @type {string}
 * @constant
 */
const APP_VERSION = "1.0.0";

/**
 * Destino seleccionado para el viaje.
 * @type {string}
 */
let destino = "Barcelona";

/**
 * Número de días previstos para el viaje.
 * @type {number}
 */
let numeroDias = 5;

/**
 * Presupuesto diario estimado en euros.
 * @type {number}
 */
let presupuestoDiario = 75;

/**
 * Indica si el viaje está confirmado.
 * @type {boolean}
 */
let viajeConfirmado = false;

/**
 * Categorías de gastos previstas.
 * @type {string[]}
 */
const categoriasGasto = ["transporte", "alojamiento", "comida", "actividades"];
