package paquete;

import java.util.Random;

public class TrenC2 implements Runnable {
    private int id;
    private int direccion;
    private Caso2 via;
    private Random random = new Random();

    public TrenC2(int id, int direccion, Caso2 via) {
        this.id = id;
        this.direccion = direccion;
        this.via = via;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(random.nextInt(600));
            this.via.entrar(this.id,this.direccion);
            Thread.sleep(1200);
            this.via.salir(this.id, this.direccion);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
