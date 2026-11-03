package paquete;

public class Barquero implements Runnable {
    private final Bote bote;

    public Barquero(Bote bote) {
        this.bote = bote;
    }

    @Override
    public void run() {
        try {
            while (bote.zarpar()) {
                Thread.sleep(1000);   // tiempo de cruce, afuera del lock
                bote.llegar();
            }
            System.out.println("El barquero amarra el bote: cruzaron todos.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}