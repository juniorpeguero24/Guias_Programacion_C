package paquete;

public class Libro extends Prestable {
    private static int sig = 0;   // contador propio de libros

    public Libro(String titulo) {
        super(sig++, titulo);
    }

    public static int getSig() {
        return sig;
    }
}