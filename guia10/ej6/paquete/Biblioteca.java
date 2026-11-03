package paquete;

import java.util.HashMap;

public class Biblioteca {
    private final HashMap<Integer, Libro> libros = new HashMap<>();       // CAMBIO: inicializados
    private final HashMap<Integer, Revista> revistas = new HashMap<>();
    private final Object lockLibros = new Object();
    private final Object lockRevistas = new Object();

    public Biblioteca() {
        cargar();
    }

    private void cargar() {
        String[] titulosLibros = {"Rayuela", "Ficciones", "El tunel", "Martin Fierro", "Sobre heroes y tumbas"};
        for (String t : titulosLibros) {
            Libro l = new Libro(t);
            libros.put(l.getId(), l);
        }
        String[] titulosRevistas = {"Caras y Caretas", "Sur", "Billiken", "Rolling Stone", "Muy Interesante"};
        for (String t : titulosRevistas) {
            Revista r = new Revista(t);
            revistas.put(r.getId(), r);
        }
    }

    // ===================== LIBROS =====================

    public int getCantidadLibros() {                 // CAMBIO: sin synchronized en la firma
        synchronized (lockLibros) {
            return Libro.getSig();
        }
    }

    public Libro retirarLibro(String nombre, int id) throws InterruptedException {
        synchronized (lockLibros) {
            while (!libros.containsKey(id)) {
                System.out.println("   " + nombre + " espera el libro " + id);
                lockLibros.wait();
            }
            Libro libro = libros.remove(id);
            System.out.println(nombre + " retiro el libro: " + libro.getTitulo());
            return libro;                            // CAMBIO: sin this.notifyAll()
        }
    }

    public void devolverLibro(String nombre, Libro libro) {
        synchronized (lockLibros) {                  // CAMBIO: la llave correcta
            libros.put(libro.getId(), libro);
            System.out.println(nombre + " devolvio el libro: " + libro.getTitulo());
            lockLibros.notifyAll();
        }
    }

    // ===================== REVISTAS =====================

    public int getCantidadRevistas() {
        synchronized (lockRevistas) {
            return Revista.getSig();
        }
    }

    public Revista retirarRevista(String nombre, int id) throws InterruptedException {
        synchronized (lockRevistas) {
            while (!revistas.containsKey(id)) {
                System.out.println("   " + nombre + " espera la revista " + id);
                lockRevistas.wait();
            }
            Revista revista = revistas.remove(id);
            System.out.println(nombre + " retiro la revista: " + revista.getTitulo());
            return revista;
        }
    }

    public void devolverRevista(String nombre, Revista revista) {
        synchronized (lockRevistas) {
            revistas.put(revista.getId(), revista);
            System.out.println(nombre + " devolvio la revista: " + revista.getTitulo());
            lockRevistas.notifyAll();
        }
    }
}