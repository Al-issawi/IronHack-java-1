/**
 * Zapato comodo para el uso diario.
 *
 * @author  Mohammed Alisawi
 * @see Zapato
 */
public class ZapatoCasual extends Zapato {
    /**
     * Crea un zapato casual.
     *
     * @param marca marca comercial
     * @param talla talla europea
     * @param precio precio en euros
     */
    public ZapatoCasual(String marca, int talla, double precio) {
        super(marca, talla, precio);
    }

    /**
     * {@inheritDoc}
     *
     * @return la categoria casual
     */
    @Override
    public String getTipo() {
        return "Casual";
    }
}
