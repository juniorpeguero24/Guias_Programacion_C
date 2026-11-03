package paquete;

public class Revista extends Prestable {
    private static int sig = 0;   // contador propio de revistas

    public Revista(String titulo) {
        super(sig++, titulo);
    }

    public static int getSig() {
        return sig;
    }
}