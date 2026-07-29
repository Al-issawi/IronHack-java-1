import java.awt.*;

public class Juguete {

    private String nombreJuegete;
    private double precio;
    private Dimension dimension;

    public Juguete() {
    }

    public Juguete(String nombreJuegete, double precio, Dimension dimension) {
        this.nombreJuegete = nombreJuegete;
        this.precio = precio;
        this.dimension = dimension;
    }

    public double getPrecio() {
        return precio;
    }
    public String getNombreJuegete() {
        return nombreJuegete;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setNombreJuegete(String nombreJuegete) {
        this.nombreJuegete = nombreJuegete;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }


    @Override
    public String toString() {
        return "Juguete{" +
                "nombreJuegete='" + nombreJuegete + '\'' +
                ", precio=" + precio +
                ", dimension=" + dimension +
                '}';
    }
}

