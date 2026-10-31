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
                int id = random.nextInt(Libro.getSig());
                System.out.println(this.nombre + " quiere el libro " + id);

                Libro libro = this.biblioteca.retirar(this.nombre, id);
                System.out.println(this.nombre+" retiro: "+libro.getTitulo());

                Thread.sleep(3000);

                this.biblioteca.devolver(libro);
                System.out.println(this.nombre+" devolvio: "+libro.getTitulo());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
