import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Create a Scanner object to read user input from the console
        Scanner scanner = new Scanner(System.in);

        // Create three Bicicleta objects with fixed data
        Bicicleta bicicleta1 = new Bicicleta(
                "Orbea",
                "Alma",
                35,
                true
        );

        Bicicleta bicicleta2 = new Bicicleta(
                "Trek",
                "Marlin",
                30,
                true
        );

        Bicicleta bicicleta3 = new Bicicleta(
                "BMX",
                "Street",
                25,
                false
        );

        // Show the bicycles created manually
        System.out.println("BICICLETAS SUELTAS:");

        System.out.println(bicicleta1);
        System.out.println(bicicleta2);
        System.out.println(bicicleta3);

        // Create an ArrayList to store several Bicicleta objects
        ArrayList<Bicicleta> bicicletas = new ArrayList<>();

        // Add the existing bicycles to the ArrayList
        bicicletas.add(bicicleta1);
        bicicletas.add(bicicleta2);
        bicicletas.add(bicicleta3);

        // Print all bicycles using a for-each loop
        System.out.println("\nRECORRIDO CON FOR-EACH:");

        for (Bicicleta bicicleta : bicicletas) {
            System.out.println(bicicleta);
        }

        // Show only the brand and maximum speed of each bicycle
        System.out.println("\nMARCA Y VELOCIDAD MÁXIMA:");

        for (Bicicleta bicicleta : bicicletas) {
            System.out.println(
                    "Marca: " + bicicleta.getMarca() +

                            " | Velocidad máxima: " +
                            bicicleta.getVelocidadMaxima() + " km/h"
            );
        }

        // Show the first bicycle before changing its brand
        System.out.println("\nANTES DEL CAMBIO:");

        System.out.println(bicicletas.get(0));

        // Change the brand of the first bicycle in the list
        bicicletas.get(0).setMarca("Specialized");

        // Show the first bicycle after the change
        System.out.println("\nDESPUÉS DEL CAMBIO:");

        System.out.println(bicicletas.get(0));

        //  methods from the Bicicleta class
        System.out.println("\nMÉTODOS DE LA BICICLETA:");

        bicicleta1.pedalear();
        bicicleta1.cambiarMarchas();
        bicicleta1.parar();

        // Ask the user to create a new bicycle
        System.out.println("\nCREAR UNA NUEVA BICICLETA");

        // Ask for the brand
        System.out.print("Introduce la marca: ");
        String marca = scanner.nextLine();

        // Ask for the model
        System.out.print("Introduce el modelo: ");
        String modelo = scanner.nextLine();

        // Ask for the maximum speed using a method that validates the input
        int velocidadMaxima = pedirVelocidadMaxima(scanner);

        // Ask whether the bicycle has gears using a method that validates the answer
        boolean tieneMarchas = pedirTieneMarchas(scanner);

        // Create a new Bicicleta object with the user input
        Bicicleta bicicletaNueva = new Bicicleta(
                marca,
                modelo,
                velocidadMaxima,
                tieneMarchas
        );

        // Add the new bicycle to the ArrayList
        bicicletas.add(bicicletaNueva);

        // Show all bicycles, including the new one created by the user
        System.out.println("\nTODAS LAS BICICLETAS:");

        for (Bicicleta bicicleta : bicicletas) {
            System.out.println(bicicleta);
        }

        // Close the Scanner to free resources
        scanner.close();
    }

    // Method that asks the user for the maximum speed and validates that it is a positive integer
    private static int pedirVelocidadMaxima(Scanner scanner) {
        while (true) {
            // Read the input as text to avoid Scanner input mismatch errors
            System.out.print("Introduce la velocidad máxima: ");
            String respuesta = scanner.nextLine().trim();

            try {
                // Convert the text input into an integer
                int velocidad = Integer.parseInt(respuesta);

                // Return the value only if it is greater than 0
                if (velocidad > 0) {
                    return velocidad;
                }

                // Message shown if the number is 0 or negative
                System.out.println("La velocidad debe ser mayor que 0.");
            } catch (NumberFormatException e) {
                // Message shown if the user does not enter a valid integer
                System.out.println("Introduce un número entero válido.");
            }
        }
    }

    // Method that asks whether the bicycle has gears and converts the answer into a boolean
    private static boolean pedirTieneMarchas(Scanner scanner) {
        while (true) {
            // Read the user's answer as text and normalize it:
            // trim() removes spaces before and after
            // toLowerCase() makes the comparison case-insensitive
            System.out.print("¿Tiene marchas? (sí/no): ");
            String respuesta = scanner.nextLine().trim().toLowerCase();

            // Accept several positive answers and return true
            if (
                    respuesta.equals("sí")
            ) {
                return true;
            }

            // Accept several negative answers and return false
            if (
                    respuesta.equals("no")
            ) {
                return false;
            }

            // If the answer is not recognized, ask again
            System.out.println("Respuesta no válida. Escribe sí o no.");
        }
    }
}