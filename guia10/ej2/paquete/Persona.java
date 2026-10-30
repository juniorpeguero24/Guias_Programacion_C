package paquete;

import java.util.Random;

public class Persona implements Runnable{
    private static int nSig = 0;
    private int id;
    private Mostrador mostrador;
    private Random random = new Random();

    public Persona(Mostrador mostrador) {
        this.id = nSig++;
        this.mostrador = mostrador;
    }

    @Override
    public void run() {
        int vueltas = 5;
        for (int i = 0; i < vueltas; i++) {
            try{
                Thread.sleep(random.nextInt(1000));
                this.mostrador.atender(this.id);
                Thread.sleep(1500);
                this.mostrador.despachar(this.id);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

    }
}
