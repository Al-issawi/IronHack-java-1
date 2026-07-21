//1-Condicionales numeros
//        Preguntas la edad, y según la respuesta, le contestas:
//        estás en primaria/ secundaria/ universidad/ trabajando
//        +EXTRA: que si pone menos de 6 o más 120, dar un mensaje de error
//        2- Condicionales texto
//        Se pregunta el color favorito al usuario. Si coincide con el color favorito del programador, previamente guardado, mensaje positivo.   Si no, mensaje negativo
//        3- Bucle for descendente
//        Se pide un número positivo, y el bucle que imprima desde ese número a cero
//        4- For con condicionales
//        Crea un programa que:
//        Pida al usuario 10 notas (entre 0 y 10).


import java.util.Scanner;
public class ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Cuál es tu posición de entrada? ");
        int posicion = sc.nextInt();

        // Consumir el salto de línea que deja nextInt()
        sc.nextLine();

        System.out.print("Introduce tu nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Introduce tu apellido: ");
        String apellido = sc.nextLine();

        System.out.print("Introduce tu edad: ");
        int edad = sc.nextInt();

        System.out.println(
                "En el puesto " + posicion +
                        ", está " + nombre + " " + apellido +
                        " con " + edad + " años. ¡Bienvenid@ a Ironhack!"
        );

        sc.close();
    }
}