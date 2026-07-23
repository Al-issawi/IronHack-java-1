import java.util.Scanner;

/* **********************************
    1. procesarFrase()
       → No parameters
       → No return
       → Scanner inside method
       → Prints inside method

    2. procesarFrase1()
       → No parameters
       → Returns String
       → Scanner inside method
       → main() prints result

    3. procesarFrase2(nombre, destino)
       → Has parameters
       → No return
       → Scanner in main()
       → Method prints result

    4. procesarFrase3(nombre, destino)
       → Has parameters
       → Returns String
       → Scanner in main()
       → main() prints result
    *
* ************************************* */

public class fraces4Metodos {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Variables
        String nombre;
        String destino;

        String frase2;
        String frase4;


        // =========================================
        // 1. SIN PARÁMETROS Y SIN RETURN
        // =========================================

        System.out.println("----- MÉTODO 1: Sin parámetros y sin return -----");

        procesarFrase();


        // =========================================
        // 2. SIN PARÁMETROS Y CON RETURN
        // =========================================

        System.out.println("\n----- MÉTODO 2: Sin parámetros y con return -----");

        frase2 = procesarFrase1();

        System.out.println(frase2);


        // =========================================
        // 3. CON PARÁMETROS Y SIN RETURN
        // =========================================

        System.out.println("\n----- MÉTODO 3: Con parámetros y sin return -----");

        System.out.print("Introduce tu nombre: ");
        nombre = scanner.nextLine();

        System.out.print("Introduce tu destino: ");
        destino = scanner.nextLine();

        procesarFrase2(nombre, destino);


        // =========================================
        // 4. CON PARÁMETROS Y CON RETURN
        // =========================================

        System.out.println("\n----- MÉTODO 4: Con parámetros y con return -----");

        System.out.print("Introduce tu nombre: ");
        nombre = scanner.nextLine();

        System.out.print("Introduce tu destino: ");
        destino = scanner.nextLine();

        frase4 = procesarFrase3(nombre, destino);

        System.out.println(frase4);


        scanner.close();
    }


    // =========================================
    // 1. SIN PARÁMETROS Y SIN RETURN
    // =========================================

    public static void procesarFrase() {

        String nombre;
        String destino;

        System.out.print("Introduce tu nombre: ");
        nombre = scanner.nextLine();

        System.out.print("Introduce tu destino: ");
        destino = scanner.nextLine();

        String resultado = nombre + " veranea en " + destino;

        System.out.println(resultado);
    }


    // =========================================
    // 2. SIN PARÁMETROS Y CON RETURN
    // =========================================

    public static String procesarFrase1() {

        String nombre;
        String destino;

        System.out.print("Introduce tu nombre: ");
        nombre = scanner.nextLine();

        System.out.print("Introduce tu destino: ");
        destino = scanner.nextLine();

        String resultado = nombre + " veranea en " + destino;

        return resultado;
    }


    // =========================================
    // 3. CON PARÁMETROS Y SIN RETURN
    // =========================================

    public static void procesarFrase2(String nombre, String destino) {

        System.out.println(nombre + " veranea en " + destino);
    }


    // =========================================
    // 4. CON PARÁMETROS Y CON RETURN
    // =========================================

    public static String procesarFrase3(String nombre, String destino) {

        String resultado = nombre + " veranea en " + destino;

        return resultado;
    }
}