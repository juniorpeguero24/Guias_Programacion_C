package paquete;

import java.util.Observable;
import java.util.Random;

public class Mascota extends Observable implements Runnable{
    private String nombre;
    private Random random = new Random();
    private Estados[] estados = Estados.values();

    public Mascota(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try{
            while (true){
                Thread.sleep(random.nextInt(3000,10001));
                this.informa(estados[random.nextInt(estados.length)]);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void informa(Estados estado) {
        setChanged();
        notifyObservers(estado);
    }

    public String getNombre() {
        return nombre;
    }
}
