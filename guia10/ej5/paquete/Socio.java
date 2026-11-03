package paquete;

import java.util.Random;

public class Socio implements Runnable {
    private String nombre;
    private Biblioteca biblioteca;
    private Random random = new Random();

    public Socio(String nombre,Biblioteca biblioteca) {
        this.nombre = nombre;
        this.biblioteca=biblioteca;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(random.nextInt(2000));
                int id = random.nextInt(biblioteca.getCantidadLibros());
                System.out.println(this.nombre + " quiere el libro " + id);
                Libro libro = this.biblioteca.retirar(this.nombre, id);
                Thread.sleep(3000);
                this.biblioteca.devolver(this.nombre,libro);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
