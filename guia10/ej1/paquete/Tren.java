package paquete;

import java.util.Random;

public class Tren implements Runnable {
    private int id;
    private Caso1 via;
    private Random random = new Random();

    public Tren(int id, Caso1 via) {
        this.id = id;
        this.via = via;
    }

    @Override
    public void run() {
        try{
            Thread.sleep(random.nextInt(1000));
            via.entrar(this.id);
            Thread.sleep(1500);
            via.salir(this.id);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
