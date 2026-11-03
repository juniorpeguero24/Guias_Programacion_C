package paquete;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Cambiá estos dos valores para probar distintos casos
        int cantA = 10;
        int cantB = 5;

        String[] nombres = {"Ana", "Juan", "Pedro", "Lucia", "Martin", "Sofia", "Diego", "Valen",
                "Tomas", "Caro", "Nico", "Flor", "Agus", "Mica", "Facu", "Belu", "Santi", "Cami",
                "Lucho", "Juli", "Fede", "Pili", "Gonza", "Abril", "Rami", "Male", "Bruno", "Ludmi"};

        Bote bote = new Bote(cantA + cantB);          // CAMBIO: el bote sabe cuántos son en total
        List<Thread> hilos = new ArrayList<>();
        hilos.add(new Thread(new Barquero(bote)));    // NUEVO: el barquero también es un hilo

        for (int i = 0; i < cantA + cantB; i++) {
            int orilla = (i < cantA) ? 0 : 1;
            String nombre = nombres[i % nombres.length] + (i >= nombres.length ? i : "");
            hilos.add(new Thread(new Persona(nombre, orilla, bote)));
        }

        for (Thread h : hilos) h.start();
        for (Thread h : hilos) h.join();

        System.out.println("Simulacion terminada: todos cruzaron.");
    }
}