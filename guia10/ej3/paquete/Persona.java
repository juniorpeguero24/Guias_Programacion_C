package paquete;

import java.util.Random;

public class Persona implements Runnable{
    private static int nSig = 0;
    private int id;
    private Mesa mesa;
    private Random random = new Random();

    public Persona(Mesa mesa) {
        this.id = nSig++;
        this.mesa = mesa;
    }

    @Override
    public void run() {
        try {
            boolean sigue = true;
            while (sigue) {
                Thread.sleep(random.nextInt(1000));
                sigue = mesa.atender(id);
                if (sigue) {
                    Thread.sleep(500);
                    mesa.despachar(id);
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
