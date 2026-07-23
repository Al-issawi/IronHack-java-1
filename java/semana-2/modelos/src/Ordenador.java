public class Ordenador {

    private String marca;
    private String modelo;
    private int memoriaRAM;
    private int capacidadDiscoDuro;

    private double precio;

    public Ordenador(){

    }

    //**constructor**//
    public Ordenador(String marca, String modelo, int memoriaRAM, int capacidadDiscoDuro, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.memoriaRAM = memoriaRAM;
        this.capacidadDiscoDuro = capacidadDiscoDuro;
        this.precio = precio;
    }



    //getters

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getMemoriaRAM() {
        return memoriaRAM;
    }

public int getCapacidadDiscoDuro() {
        return capacidadDiscoDuro;
}

    public double getPrecio() {
        return precio;
    }

    //Stetters


    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    public void setMemoriaRAM(int memoriaRAM){
        this.memoriaRAM = memoriaRAM;
    }
    public void setCapacidadDiscoDuro(int capacidadDiscoDuro){
        this.capacidadDiscoDuro = capacidadDiscoDuro;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String toString (){
        return ("Marca: " + marca + "\n Modelo: " + modelo + " " + "\nMemoria del Ram: "
                + memoriaRAM + "\nCapacidad Duro: " + capacidadDiscoDuro + " " + "\nPrecio: " + precio);
    }
}
