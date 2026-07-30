import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {

    public  static void main(String[] args){

        ArrayList<Zapato> zapatoArrayList= new ArrayList<>();

        zapatoArrayList.add(new Casual(" Casual1 ", 43,80.80d," Uso-diarios " ));
        zapatoArrayList.add(new Casual(" Nike ", 40, 42.40d," caminar "));
        zapatoArrayList.add(new Elegante(" Clarks ", 43, 43.00d, true));
        zapatoArrayList.add(new Deporte(" Adidas ", 35, 41.40d, " Running "));
        zapatoArrayList.add(new Casual(" Puma ", 54, 400.34d," montaña"));
        zapatoArrayList.add(new Elegante(" Hugo Boss ", 40, 44.5d, false));


        //añadir precio total.
        double totlaPrecio = 0.0;

        for (Zapato zapato : zapatoArrayList) {

            //morstat toda la lista de zapatos
            System.out.println("\n ****************** \n zapatos \n ****************** \n"
                    + zapato);

            //mostrar zapato solo con marca y precio

            //sumar los precios añadidos.
            totlaPrecio += zapato.getPrecio();

            //morstat todos los precios.

            System.out.println("total  actulizado: " + totlaPrecio + "$");



        }


        System.out.println( " ****************************************************************************** " +"\n");
        // Acceder a un atributo específico de Deporte
        Deporte deporte = (Deporte) zapatoArrayList.get(3);
        System.out.println(deporte.getMarca() + " ---- " + deporte.getDeporte());

        //directamte accesso al atriputos
        System.out.println("\n Accesso directamnte al atriputos : ");

        System.out.println(zapatoArrayList.get(3).getMarca() + " ---- " + ((Deporte) zapatoArrayList.get(3)).getDeporte());

        /*############################################################################################################*/
        //solo la clase casual.
        System.out.println("\nZapatos casuales:");
        for (Zapato zapato : zapatoArrayList) {

            if (zapato instanceof Casual) {
                System.out.println(zapato);
            }
        }

        System.out.println( " ****************************************************************************** " +"\n");

        /*###################################################################################################### */

            //elementos de las clases
            System.out.println("\nClase del segundo elemento:");
            // getClass() te dice de que clase es un elemento:

            System.out.println(zapatoArrayList.get(3).getClass().getSimpleName());

        System.out.println( " ****************************************************************************** " +"\n");

            /* ###################################################################################################### */


        // Cambiar un atributo heredado

        System.out.println("\ncambiar el  segundo atributo:");

        zapatoArrayList.get(3).setPrecio(200.32);
        System.out.println("\n precio actulizado \n "+ zapatoArrayList.get(3));


        System.out.println( " ****************************************************************************** " +"\n");




    }
}
