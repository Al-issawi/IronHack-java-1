import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String frase;
        int opcion=0;
        String resultado;

//       Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce una frase: ");
        frase = scanner.nextLine();

        System.out.print("Introduce una opción (1, 2 o 3): ");
        opcion = scanner.nextInt();

        //** Call the method to process the phrase based on the option */
        resultado = tratarFrase(frase, opcion);

        //** Print the result */
        System.out.println("Resultado: " + resultado);

        //** as it is static, we don't need to close it, and closing it would close System.in, which we might want to use later in the program. */

        //scanner.close();
    }

    //** Method to process the phrase based on the option */

    public static String tratarFrase(String frase, int opcion) {

        switch (opcion) {

            case 1:
                return frase.toUpperCase();

            case 2:
                return frase.toLowerCase();

            case 3:
                String fraseAlReves = "";

                for (int i = frase.length() - 1; i >= 0; i--) {
                    fraseAlReves += frase.charAt(i);
                }

                return fraseAlReves;

            default:
                return "Opción no válida";
        }
    }
}

