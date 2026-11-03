package paquete;

import java.util.HashMap;

public class Biblioteca {
    private HashMap<Integer, Libro> libros;
    private final int capacidad_maxima = 10;

    public Biblioteca() {
        this.libros = new HashMap<>();
        cargarLibros();
    }

    private void cargarLibros() {
        Libro l1=new Libro("Rayuela");
        Libro l2=new Libro("Ficciones");
        Libro l3=new Libro("El tunel");
        Libro l4=new Libro("Martin Fierro");
        Libro l5=new Libro("Sobre heroes y tumbas");
        this.libros.put(l1.getIdLibro(),l1);
        this.libros.put(l2.getIdLibro(),l2);
        this.libros.put(l3.getIdLibro(),l3);
        this.libros.put(l4.getIdLibro(),l4);
        this.libros.put(l5.getIdLibro(),l5);
    }

    public synchronized int getCantidadLibros() {
        return Libro.getSig();
    }

    public synchronized void donar(String titulo) throws InterruptedException {
        while (this.libros.size() >= capacidad_maxima) {
            System.out.println(" Estanteria llena, en espera la donacion.");
            wait();
        }
        Libro libro = new Libro(titulo);
        this.libros.put(libro.getIdLibro(), libro);
        System.out.println("Prestable donado: "+libro.getTitulo()+" id "+libro.getIdLibro());
    }

    public synchronized Libro retirar(String nombre,int id) throws InterruptedException {
        while (!this.libros.containsKey(id)) {
            System.out.println("   " + nombre + " espera el libro " + id + " (está prestado)");
            wait();
        }
        Libro libro = this.libros.remove(id);
        System.out.println(nombre + " retiro: " + libro.getTitulo());
        this.notifyAll();
        return libro;
    }

    public synchronized void devolver(String nombre,Libro libro) {
        this.libros.put(libro.getIdLibro(),libro);
        System.out.println(nombre + " devolvio: " + libro.getTitulo());
        this.notifyAll();
    }
}
