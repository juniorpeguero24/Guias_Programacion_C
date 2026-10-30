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
        try{
            Thread.sleep(random.nextInt(1000));
            this.mesa.atender(this.id);
            Thread.sleep(1500);
            this.mesa.despachar(this.id);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
