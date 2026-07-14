
//EJERCICIO 2:

//programa que pide la edad de tu padre y de tu madre y da la media de edad con decimales

public class run {
    public static void main(String[] args) {

        int numero1 = 7;
        int numero2 = 3;

        //aqui se llama soft-wrap en vez de word wrap

        // para formatear la tabulacion del codigo: ctrl + alt + L (como prettier)

        //conversion de tipos ( casting,type casting): entre parentesis a que tipo va
        float numDecimal = (float) numero1 / numero2; //si no pones el float, hace div de enteros


        // System.out.println("la división de " + numero1 + " entre " + numero2 + " es: " + ((float) numero1 / numero2));

        System.out.printf("la división de %d entre %d es:  %.2f", numero1, numero2, numDecimal);

        // %.2f NO graba dos decimales en la variable, solo MUESTRA dos decimales

        // *****************************ejercicio 2************************


        int edadMadre = 59;
        int edadPadre = 65;

        float edadDecimal = (float) edadMadre / edadPadre;
        System.out.printf("la división de %d entre %d es:  %.2f", edadMadre, edadPadre, edadDecimal);

    }


}