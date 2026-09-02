import java.time.LocalDate;
import java.util.UUID;

public class Perro {

    // atributos
    private String nombre;

    // LocalDate hoy en día, no es Date
    private LocalDate fechaNacimiento;

    // EXTRA: id único para cada perro
    private UUID id;

    // con static no hace falta instanciar la clase
    private static int cantidadMinimaPaseos = 2;
    // son 2 paseos mínimo para todos los perros


    // constructores
    public Perro() {
    }

    public Perro(String nombre, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;

        // genera un id aleatorio para cada perro
        this.id = UUID.randomUUID();

        System.out.println("ha nacido un perro!");
    }


    // getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public UUID getId() {
        return id;
    }


    public static int getCantidadMinimaPaseos() {
        return cantidadMinimaPaseos;
    }

    public static void setCantidadMinimaPaseos(int cantidadMinimaPaseos) {
        Perro.cantidadMinimaPaseos = cantidadMinimaPaseos;
    }


    // métodos personalizados
    public static String ladrar() {
        return "Guau guau!";
    }


    //métodos Calcolacion de la edad
    public int calcularEdad() {
        int edad = LocalDate.now().getYear() - this.fechaNacimiento.getYear();

        return edad;
    }


    // toString personalizado
    @Override
    public String toString() {
        return "El perro se llama " + nombre +
                ", tiene el id " + id +
                ", tiene " + calcularEdad() +
                " años, dice '" + ladrar() +
                "' y necesita como mínimo " + cantidadMinimaPaseos +
                " paseos al día.";
    }
}