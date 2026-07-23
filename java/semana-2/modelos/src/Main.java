
//TIENDA INFORMATICA
//Trabajas para una tienda de informática y te encargan crear una base de datos para los nuevos ordenadores que van llegando.
//Necesitas crear el objeto Ordenador, con sus atributos correspondientes: marca, modelo, memoria RAM, capacidad del disco duro, precio ... etc (cantidad y tipo de  atributos a tu gusto, pero poner al menos 3).
//Una vez definida la clase del ordenador, crea al menos 3 instancias y prueba a imprimir los objetos en dos maneras:
//Debes añadir el metodo constructor, los getters y setters y el toString(). Recuerda no hacer copiar y pegar, ni buscar ningún método de generación de código automático. Hay que pensar y practicar, al menos por hoy!
//Siéntete libre de modificar el toString a tu gusto.
//        1. Todas sus características
//2. Imprime solo características sueltas como la marca y el precio del ordenador elegido.
//3. Probar a cambiar una propiedad de uno de los ordenadores y volver a mostrarla.//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        System.out.println("**********************************************************");
        Ordenador ordenador = new Ordenador("Dell, ", " Insprtion 25502, ", 16, 10000,  800.0d);

        System.out.println(ordenador);

        Scanner sc = new Scanner(System.in);

        System.out.println("indica Los Carasticas del Ordenador son: 1.Marca, 2.Modelo, 3.MemoriaRama, 4.Capacidad de Disco Duro, 5.Precio. ");
        ordenador = new Ordenador(

                //Marca
                sc.nextLine(),

                //Modelo
                sc.nextLine(),

                //Ram
                sc.nextInt(),

                //discoDuro
                sc.nextInt(),
                //precio
                sc.nextDouble()
        );

        System.out.println("**********************************************************");

        System.out.println(ordenador);

        System.out.println("**********************************************************");


        ordenador.setPrecio(1000.0d);
        ordenador.setMarca("HP");
        ordenador.setMemoriaRAM(16);
        ordenador.setCapacidadDiscoDuro(1000);
        ordenador.setModelo("2344fdU");


        System.out.println("El precio del ordenador es: " + ordenador.getPrecio());
        System.out.println("La marca del ordenador es: " + ordenador.getMarca());
        System.out.println("La capacidad del Disco Duro es: "+ ordenador.getCapacidadDiscoDuro());
        System.out.println("la  capacidad de RAM es:" + ordenador.getMemoriaRAM());
        System.out.println("el modelo es: " + ordenador.getModelo());

        System.out.println("**********************************************************");

    }

}