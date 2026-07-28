/*COLECCION DISCOS DE VINILO

Crear un arraylist con al menos 5 discos, con los datos: Artista, título, año, duración (pueden ser otros). Puedes crearlos directamente en vez de con input de usuario.
Menu:
1- Mostrar todos los discos, con todos los datos
2- Mostrar uno determinado: por ejemplo el año del tercer disco (esto lo podría pedir el cliente)
3- borrar uno determinado por indice
OJO, cada opción llama a su método correspondiente! (no poner e¡todo en el main)

EXTRAS:
-  buscador con equals() e indexOf(). Que el usuario escriba nombre de artista y me diga si está, y en qué posición está.
- Cambiar un disco y mostrar ese cambio (+EXTRA. crear metodo en la clase Disco para actualizarDisco que haga todos los setters a la vez)* */


import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Disco> discos = new ArrayList<>();


    public static void main(String[] args) {
        // Crear discos
        discos.add(new Disco("artista1", "disco1", 1969, 47));
        discos.add(new Disco("artista2", "disco2", 1973, 43));
        discos.add(new Disco("artista3", "disco3", 1971, 42));
        discos.add(new Disco("artista4", "disco4", 1975, 43));
        discos.add(new Disco("artista5", "disco5", 1982, 42));

        // Menu
        int opcion;

        do {
            System.out.println("Menu:");
            System.out.println("1- Mostrar todos los discos");
            System.out.println("2- Mostrar un disco determinado");
            System.out.println("3- Borrar un disco determinado");
            System.out.println("4- Buscar un disco por artista");
            System.out.println("5- Cambiar un disco");
            System.out.println("0- Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    mostrarTodosDiscos();
                    break;
                case 2:
                    mostrarDiscoDeterminado();
                    break;
                case 3:
                    borrarDiscoDeterminado();
                    break;
                case 4:
                    buscarDiscoPorArtista();
                    break;
                case 5:
                    actualizarDisco();
                    break;
                case 0:
                    System.out.println("Adios!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }


    // Actualizar disco.
    private static void actualizarDisco() {

        System.out.println(" Introduce el indice del disco que quere cambiar: ");
        int index = sc.nextInt();
        sc.nextLine();

        if (index >= 0 && index < discos.size()) {
            System.out.print("Introduce el nuevo artista: ");
            String artista = sc.nextLine();
            System.out.print("Introduce el nuevo titulo: ");
            String titulo = sc.nextLine();
            System.out.print("Introduce el nuevo año: ");
            int año = sc.nextInt();
            System.out.print("Introduce la nueva duracion: ");
            int duracion = sc.nextInt();
            sc.nextLine();

            // Utilizar el método de la clase Disco
            discos.get(index).actualizarDisco(artista, titulo, año, duracion);
            System.out.println("Disco actualizado correctamente.");
        } else {
            System.out.println("Indice no valido");
        }


    }

        private static void buscarDiscoPorArtista() {

            System.out.print("Introduce el nombre del artista que quieres buscar: ");
            String artista = sc.nextLine();

            for (int index = 0; index < discos.size(); index++) {

                if (discos.get(index).getArtistas().equalsIgnoreCase(artista)) {

                    System.out.println("Artista encontrado: " + artista);
                    System.out.println("Disco: " + discos.get(index).getTitulo());
                    System.out.println("Posición: " + index);
                    System.out.println("----------------------------------------");

                    return;
                }
            }

            System.out.println("Disco no encontrado.");
        }


    private static void borrarDiscoDeterminado() {

        System.out.print("Introduce el índice del disco que quieres borrar: ");
        int index = sc.nextInt();
        sc.nextLine();

        if (index >= 0 && index < discos.size()) {
            discos.remove(index);
            System.out.println("Disco borrado correctamente.");
            System.out.println("la lista de discos queda asi:");
            mostrarTodosDiscos();
        } else {
            System.out.println("Índice no válido.");
        }

    }

    //Mostrar todos los discos
    private static void mostrarTodosDiscos() {

        for (Disco disco : discos){
            System.out.println(disco);
        }
    }

    private static void mostrarDiscoDeterminado() {


            System.out.print("Introduce el índice del disco: ");
            int index = sc.nextInt();
            sc.nextLine();

            if (index >= 0 && index < discos.size()) {

                Disco disco = discos.get(index);

                System.out.println("\n===== DISCO SELECCIONADO =====");
                System.out.println(disco);

            } else {
                System.out.println("Índice no válido.");
            }
        }

}


