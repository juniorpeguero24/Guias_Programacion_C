package paquete;

import java.util.Random;

public class SocioLibro implements Runnable {
    private final String nombre;
    private final Biblioteca biblioteca;
    private final Random random = new Random();

    public SocioLibro(String nombre, Biblioteca biblioteca) {
        this.nombre = nombre;
        this.biblioteca = biblioteca;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(random.nextInt(2000));
                int id = random.nextInt(biblioteca.getCantidadLibros());
                System.out.println(nombre + " quiere el libro " + id);
                Libro libro = biblioteca.retirarLibro(nombre, id);
                Thread.sleep(random.nextInt(3000));
                biblioteca.devolverLibro(nombre, libro);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}