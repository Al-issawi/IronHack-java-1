/**
 * Representa un viaje y permite consultar un presupuesto estimado.
 * <p>
 * Este ejemplo de nivel 1 muestra documentacion Javadoc para una sola clase.
 * <b>El presupuesto es orientativo</b> y se expresa en euros.
 *
 * @author Mohammed Alisawi
 * @see #estimarPresupuesto(int, double)
 */
public class PlanificadorViaje {
    private final String destino;
    private final int dias;
    private final double costeDiario;

    /**
     * Crea un planificador para el destino y los costes indicados.
     *
     * @param destino nombre del lugar que se visitara
     * @param dias numero de dias del viaje; debe ser mayor que cero
     * @param costeDiario coste estimado por dia en euros; no puede ser negativo
     * @throws IllegalArgumentException si el destino esta vacio, los dias no son positivos o el coste es negativo
     */
    public PlanificadorViaje(String destino, int dias, double costeDiario) {
        if (destino == null || destino.isBlank()) {
            throw new IllegalArgumentException("El destino no puede estar vacio.");
        }
        if (dias <= 0) {
            throw new IllegalArgumentException("El viaje debe durar al menos un dia.");
        }
        if (costeDiario < 0) {
            throw new IllegalArgumentException("El coste diario no puede ser negativo.");
        }
        this.destino = destino;
        this.dias = dias;
        this.costeDiario = costeDiario;
    }

    /**
     * Devuelve el nombre del destino.
     *
     * @return el destino del viaje
     */
    public String getDestino() {
        return destino;
    }

    /**
     * Calcula el presupuesto total multiplicando los dias por el coste diario.
     *
     * @param dias numero de dias que se presupuestan
     * @param costeDiario coste estimado para cada dia, en euros
     * @return presupuesto estimado en euros
     * @throws IllegalArgumentException si los dias no son positivos o el coste es negativo
     */
    public static double estimarPresupuesto(int dias, double costeDiario) {
        if (dias <= 0 || costeDiario < 0) {
            throw new IllegalArgumentException("Indica dias positivos y un coste no negativo.");
        }
        return dias * costeDiario;
    }

    /**
     * Imprime un resumen legible del viaje y su presupuesto estimado.
     *
     * @return resumen del viaje
     * @see #estimarPresupuesto(int, double)
     */
    public String crearResumen() {
        double total = estimarPresupuesto(dias, costeDiario);
        return String.format("Viaje a %s: %d dias, presupuesto estimado %.2f EUR", destino, dias, total);
    }

    /**
     * Ejecuta el ejemplo de uso del planificador.
     *
     * @param args argumentos de linea de comandos (no se utilizan)
     */
    public static void main(String[] args) {
        PlanificadorViaje viaje = new PlanificadorViaje("Granada", 4, 72.50);
        System.out.println(viaje.crearResumen());
    }
}
