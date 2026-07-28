public class Disco {
    private String artistas;
    private String titulo;
    private int año;
    private int duracion;

    public Disco() {

    }

    public Disco(String artistas, String titulo, int año, int duracion) {
        this.artistas = artistas;
        this.titulo = titulo;
        this.año = año;
        this.duracion = duracion;
    }

    // Getters and Setters
    public String getArtistas() {
        return artistas;
    }

    public void setArtistas(String artistas) {
        this.artistas = artistas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String toString() {
        return "Disco{" +
                "artistas='" + artistas + '\'' +
                ", titulo='" + titulo + '\'' +
                ", año=" + año +
                ", duracion=" + duracion +
                '}';
    }


    public void actualizarDisco(String artistas, String titulo, int año, int duracion) {
        this.artistas = artistas;
        this.titulo = titulo;
        this.año = año;
        this.duracion = duracion;
    }
}
