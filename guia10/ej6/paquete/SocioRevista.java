package paquete;

import java.util.Random;

public class SocioRevista implements Runnable {
    private final String nombre;
    private final Biblioteca biblioteca;
    private final Random random = new Random();

    public SocioRevista(String nombre, Biblioteca biblioteca) {
        this.nombre = nombre;
        this.biblioteca = biblioteca;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(random.nextInt(2000));
                int id = random.nextInt(biblioteca.getCantidadRevistas());   // CAMBIO: revistas
                System.out.println(nombre + " quiere la revista " + id);
                Revista revista = biblioteca.retirarRevista(nombre, id);
                Thread.sleep(random.nextInt(3000));
                biblioteca.devolverRevista(nombre, revista);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}