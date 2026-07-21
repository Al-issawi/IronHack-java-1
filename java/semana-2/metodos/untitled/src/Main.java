import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String frase;
        int opcion=0;
        String resultado;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce una frase: ");
         frase = scanner.nextLine();

        System.out.print("Introduce una opción (1, 2 o 3): ");
         opcion = scanner.nextInt();

         resultado = tratarFrase(frase, opcion);

        System.out.println("Resultado: " + resultado);

        scanner.close();
    }

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

