/**
 * Calzado deportivo disenado para caminar y entrenar.
 *
 * @author  Mohammed Alisawi
 * @see Zapato
 */
public class ZapatoDeportivo extends Zapato {
    /**
     * Crea un zapato deportivo.
     *
     * @param marca marca comercial
     * @param talla talla europea
     * @param precio precio en euros
     */
    public ZapatoDeportivo(String marca, int talla, double precio) {
        super(marca, talla, precio);
    }

    /**
     * {@inheritDoc}
     *
     * @return la categoria deportiva
     */
    @Override
    public String getTipo() {
        return "Deportivo";
    }
}
