package paquete;

import java.util.Random;

public class Persona implements Runnable {
    private int orilla;
    private String nombre;
    private Bote bote;
    private Random random = new Random();
    public Persona(String nombre, int orilla, Bote bote) {
        this.bote = bote;
        this.nombre = nombre;
        this.orilla = orilla;
    }

    public int getOrilla() {
        return orilla;
    }

    public void setOrilla(int orilla) {
        this.orilla = orilla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(random.nextInt(5000));   // llegan a la orilla en momentos distintos
            bote.subir(this);
            bote.bajar(this);                     // ya no hace falta sleep: bajar espera a que llegue
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
