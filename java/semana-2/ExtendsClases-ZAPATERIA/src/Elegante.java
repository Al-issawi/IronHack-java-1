public class  Elegante extends Zapato{

    private boolean tieneHebilla = false;

    public Elegante (String marca, int tilla, Double precio,boolean tieneHebilla) {
        super(marca, tilla, precio);
        this.tieneHebilla = tieneHebilla;
    }

    public boolean isTieneHebilla() {
        return tieneHebilla;
    }

    public void setTieneHebilla(boolean tieneHebilla) {
        this.tieneHebilla = tieneHebilla;
    }

    @Override
    public String toString() {
        return  super.toString() + "\n" +
                "tienehiilla: " + tieneHebilla;
    }


    //booleans

}
