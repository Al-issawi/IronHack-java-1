public class Zapato {

    private String marca;
    private int tilla;
    private Double precio;


    public Zapato() {


    }

    public Zapato(String marca, int tilla, Double precio) {
        this.marca = marca;
        this.tilla = tilla;
        this.precio = precio;
    }

//Setters y getters


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getTilla() {
        return tilla;
    }

    public void setTilla(int tilla) {
        this.tilla = tilla;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return
                "marca:" + marca + "\n" +
                "tilla:" + tilla + "\n"+
                "precio:" + precio +"$" +"\n"

                ;

    }
}
