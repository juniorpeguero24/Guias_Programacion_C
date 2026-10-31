package paquete;

public class Libro {
    private static int sig = 0;
    private int idLibro;
    private String titulo;

    public Libro(String titulo) {
        this.idLibro = sig++;
        this.titulo = titulo;
    }

    public static int getSig() {
        return sig;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public String getTitulo() {
        return titulo;
    }
}
