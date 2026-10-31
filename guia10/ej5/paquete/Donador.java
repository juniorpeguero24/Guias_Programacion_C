package paquete;

import java.util.Random;

public class Donador implements Runnable {
    private Biblioteca biblioteca;
    private Random random = new Random();

    @Override
    public void run() {
        try{
            Thread.sleep(random.nextInt(2000));

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
