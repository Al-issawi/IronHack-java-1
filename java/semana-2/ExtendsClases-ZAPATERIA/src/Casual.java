public class Casual extends Zapato {

    private String casual;

    public Casual(String marca, int tilla, Double precio,String casual) {
        super(marca, tilla, precio);
        this.casual = casual;
    }
    //getters and setters


    public String getCasual() {
        return casual;
    }

    public void setCasual(String casual) {
        this.casual = casual;
    }

    @Override
    public String toString() {
        return  super.toString() + "\n "+
                "Tipo: " +casual;
    }
}
