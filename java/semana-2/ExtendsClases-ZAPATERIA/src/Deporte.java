
public class Deporte extends Zapato{

    private  String deporte;

    public Deporte(String marca, int tilla, Double precio, String deporte) {
        super(marca, tilla, precio);
        this.deporte=deporte;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    @Override
    public String toString() {
        return  super.toString() +  "\n" +
                "tipo: " +deporte;
    }
}
