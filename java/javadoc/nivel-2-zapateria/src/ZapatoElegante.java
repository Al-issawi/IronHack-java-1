/**
 * Zapato formal pensado para eventos y ocasiones elegantes.
 *
 * @author  Mohammed Alisawi
 * @see Zapato
 */
public class ZapatoElegante extends Zapato {
    /**
     * Crea un zapato elegante.
     *
     * @param marca marca comercial
     *
     * @param talla talla europea
     * @param precio precio en euros
     */
    public ZapatoElegante(String marca, int talla, double precio) {
        super(marca, talla, precio);
    }

    /**
     * {@inheritDoc}
     *
     * @return la categoria elegante
     */
    @Override
    public String getTipo() {
        return "Elegante";
    }
}
