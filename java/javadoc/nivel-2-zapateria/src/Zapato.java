/**
 * Modelo base de un zapato de la tienda.
 * <p>Los tipos concretos heredan esta clase para compartir talla, precio y descripcion.
 *
 * @author  Mohammed Alisawi
 * @see ZapatoElegante
 * @see ZapatoCasual
 * @see ZapatoDeportivo
 */
public abstract class Zapato {
    private final String marca;
    private final int talla;
    private final double precio;

    /**
     * Crea un zapato con marca, talla y precio.
     *
     * @param marca marca del zapato
     * @param talla talla europea, entre 15 y 50
     * @param precio precio en euros; debe ser mayor que cero
     * @throws IllegalArgumentException si los datos no son validos
     */
    protected Zapato(String marca, int talla, double precio) {
        if (marca == null || marca.isBlank() || talla < 15 || talla > 50 || precio <= 0) {
            throw new IllegalArgumentException("Marca, talla o precio no validos.");
        }
        this.marca = marca;
        this.talla = talla;
        this.precio = precio;
    }

    /**
     * Devuelve la marca del zapato.
     *
     * @return marca comercial
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Devuelve la talla europea.
     *
     * @return talla del zapato
     */
    public int getTalla() {
        return talla;
    }

    /**
     * Devuelve el precio del zapato.
     *
     * @return precio en euros
     */
    public double getPrecio() {
        return precio;
    }

    /** 
     * @param crearFicha(
     * @return String
     */
    /** 
     * @param crearFicha(
     * @return String
     */
    /**
     * Describe el tipo de zapato para el catalogo.
     *
     * @return descripcion del modelo
     */
    public abstract String getTipo();

    /**
     * Crea una linea de catalogo con el tipo, la marca, la talla y el precio.
     *
     * @return linea descriptiva del zapato
     */
    public String crearFicha() {
        return String.format("%s - %s, talla %d, %.2f EUR", getTipo(), marca, talla, precio);
    }
}
