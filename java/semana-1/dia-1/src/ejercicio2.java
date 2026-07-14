
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public  class ejercicio2 {
    public static void EjercicioUno() {//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.


        int edad =34;
        Scanner sc = new Scanner(System.in);


        System.out.println("intreduzca el posicion:");

        int posicion = sc.nextInt();
        sc.nextLine(); //limpia la linea (limpiar el buffer.

        System.out.println("intreduzca el Nombre:");
        String  nombre = sc.nextLine();



        System.out.println("intreduzca el apellido:");
        String  apellido = sc.nextLine();


        System.out.println("edad :");
        edad = sc.nextInt();


        System.out.println( "Nombre: "+ nombre + "\npellido: " + apellido + " \nEdad: " + edad + ", " + "\nPosicion: " + posicion );

        sc.close();

    }
}




//public class Main {
//
//
//
//    public static void main(String[] args) {
//
//        // psvm (live template / snippet)
//
//
//
//        // System.out. es para mostrar datos
//
//        // System.in para leer datos por teclado, pero necesita de la clase Scanner
//
//        // clases: PascalCase (primera letra en mayúsculas)
//
//        // métodos en camelcase (primera en minuscula)
//
//        // por eso hay clase Main y metodo main
//
//
//
//        System.out.println("hola mundo 3"); //sout  //syso en vscode y Eclipse
//
//        System.out.println("hola mundo 5");
//
//
//
//        int numero1 = 55;
//
//        String frase = "adiós mundo";
//
//        String pais;
//
//        int numFav;
//
//
//
//        Scanner teclado = new Scanner(System.in);
//
//        System.out.println("introduce tu país favorito");
//
//        pais = teclado.nextLine(); //metodo de la clase Scanner
//
//
//
//        System.out.println("a mí también me gusta " + pais );
//
//        System.out.println("introduce tu número favorito");
//
//        numFav = teclado.nextInt();
//
//
//
//        System.out.println("compraré en la ONCE el número " + numFav);
//
//    }
//}


//        versión ampliada:
//
//        import java.util.Scanner; //para poder usar la clase Scanner
//
//
//
//        public class Main {
//
//
//
//            public static void main(String[] args) {

// psvm (live template / snippet)



// System.out. es para mostrar datos

// System.in para leer datos por teclado, pero necesita de la clase Scanner

// clases: PascalCase (primera letra en mayúsculas)

// métodos en camelcase (primera en minuscula)

// por eso hay clase Main y metodo main


//
//                System.out.println("hola mundo 3"); //sout  //syso en vscode y Eclipse
//
//                System.out.println("hola mundo 5");
//
//
//
//                int numero1 = 55;
//
//                String frase = "adiós mundo";
//
//                int posicion;
//
//                String pais;
//
//                int numFav;
//
//
//
//                Scanner teclado = new Scanner(System.in); //teclado es una instancia de la clase Scanner
//
//
//
//                System.out.println("en qué posición quedará España en el mundial?");
//
//                posicion = teclado.nextInt(); //no incluye salto de linea
//
//                teclado.nextLine(); //limpia la linea (limpiar el buffer)----------
//
//
//
//                System.out.println("introduce tu país favorito");
//
//                pais = teclado.nextLine(); //método de la clase Scanner
//
//
//
//                System.out.println("a mí también me gusta " + pais );
//
//                System.out.println("introduce tu número favorito");
//
//                numFav = teclado.nextInt();
//
//
//
//                System.out.println("compraré en la ONCE el número " + numFav);
//
//
//
//                teclado.close(); // para cerrar recurso de lectura de teclado
//
//                // numFav = teclado.nextInt(); daría error porque teclado ya está cerrado
//
//            }
//
//
//
//        }