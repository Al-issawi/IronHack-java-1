public class Bicicleta {

    private String marca;
    private String modelo;
    private int velocidadMaxima;
    private boolean tieneMarchas;

    // Constructor
    public Bicicleta(String marca, String modelo, int velocidadMaxima, boolean tieneMarchas) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadMaxima = velocidadMaxima;
        this.tieneMarchas = tieneMarchas;
    }

    // Getters y Setters

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public boolean isTieneMarchas() {
        return tieneMarchas;
    }

    public void setTieneMarchas(boolean tieneMarchas) {
        this.tieneMarchas = tieneMarchas;
    }

    // Métodos

    public void pedalear() {
        System.out.println("La bicicleta está pedaleando.");
    }

    public void parar() {
        System.out.println("La bicicleta se ha parado.");
    }


    public void cambiarMarchas() {
        if (tieneMarchas) {
            System.out.println("Se ha cambiado de marcha.");
        } else {
            System.out.println("Esta bicicleta no tiene marchas.");
        }
    }

    // toString

    @Override
    public String toString() {

        String textoMarchas;

        if (tieneMarchas) {
            textoMarchas = "Sí incluye cambio de marchas";
        } else {
            textoMarchas = "No incluye cambio de marchas";
        }

        return "Bicicleta{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", velocidadMaxima=" + velocidadMaxima + " km/h" +
                ", " + textoMarchas +
                '}';
    }
}