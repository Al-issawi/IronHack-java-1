import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {


        // Crear dimensiones
        Dimension dimension1 = new Dimension(0.5, 0.4, 0.3);
        Dimension dimension2 = new Dimension(1.0, 0.5, 0.4);
        Dimension dimension3 = new Dimension(1.2, 0.8, 0.6);


        // crear juegos
        Juguete juguete1 = new Juguete("Juego1", 29.99, dimension1);
        Juguete juguete2 = new Juguete("juego2", 19.99, dimension2);
        Juguete juguete3 = new Juguete("juego3", 39.99, dimension3);

        // Mostrar información
//        mostrar(juguete1);
//        mostrar(juguete2);
//        mostrar(juguete3);

    // Crear ArrayList de juguetes
    ArrayList<Juguete> juguetes = new ArrayList<>();

    // Añadir juguetes al ArrayList
        juguetes.add(juguete1);
        juguetes.add(juguete2);
        juguetes.add(juguete3);

    // Recorrer el ArrayList y mostrar la información de cada juguete del metodo mostrar
        for(Juguete juguete : juguetes) {
        mostrar(juguete);

        }

}


    // Metodo mostrar la información del juguete
    private static void mostrar(Juguete juguete) {

        // Calcular el volumen
        double volumen = juguete.getDimension().calcularVolumen();

        // Calcular los gastos de envío
        double gastosEnvio = calcularGastosEnvio(volumen);

        // Calcular el precio final
        double precioFinal = calcularPrecioFinal(juguete);

        System.out.println("--------------------------------------");
        System.out.println("Nombre: " + juguete.getNombreJuegete());
        System.out.println("Precio: $" + juguete.getPrecio());
        System.out.println("Dimensiones: " + juguete.getDimension());
        System.out.println("Volumen: " + volumen + " m³");
        System.out.println("Gastos de envío: $" + gastosEnvio);
        System.out.println("Precio final: $" + precioFinal);
        System.out.println("--------------------------------------");
    }



//calcular gastos.
    private static double calcularGastosEnvio(double Volumen) {
        // Implementación del cálculo de gastos de envío basado en el volumen
        if (Volumen < 5) {
            return 5.0;
        }
        else if (Volumen > 5 && Volumen < 20) {
            return 10.0;
        }
        else{
            return 20.0;
        }
    }

    //Método para calcular el precio final
    private static double calcularPrecioFinal(Juguete juguete) {

        double precioJuguete = juguete.getPrecio();

        double volumen = juguete.getDimension().calcularVolumen();

        double gastosEnvio = calcularGastosEnvio(volumen);

        return precioJuguete + gastosEnvio;
    }
}

