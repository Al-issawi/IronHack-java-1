/**
 * Ejecuta una demostracion del catalogo de la zapateria.
 * <p>Reune tres clases de calzado y muestra sus fichas por consola.
 *
 * @author Mohammed Alisawi
 * @see Zapato
 */
public class ZapateriaApp {
    /**
     * Crea la aplicacion de demostracion de la zapateria.
     */
    public ZapateriaApp() {
    }    /**
     * Muestra un zapato de cada categoria disponible.
     *
     * @param args argumentos de linea de comandos (no se utilizan)
     */
    public static void main(String[] args) {
        Zapato[] catalogo = {
            new ZapatoElegante("Luna", 39, 89.90),
            new ZapatoCasual("Norte", 42, 64.50),
            new ZapatoDeportivo("Ritmo", 41, 79.95)
        };

        for (Zapato zapato : catalogo) {
            System.out.println(zapato.crearFicha());
        }
    }
}


