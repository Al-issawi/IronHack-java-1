import java.time.LocalDate;

public class Main {


    public static void main(String[] args) {

        Perro perro1 = new Perro(
                "Toby",
                LocalDate.of(2022, 5, 10)
        );

        Perro perro2 = new Perro(
                "Rocky",
                LocalDate.of(2020, 3, 15)
        );

        Perro perro3 = new Perro(
                "Luna",
                LocalDate.of(2023, 8, 20)
        );

        System.out.println(perro1);
        System.out.println(perro2);
        System.out.println(perro3);

        System.out.println("Número mínimo de paseos: "
                + Perro.getCantidadMinimaPaseos());
    }
}