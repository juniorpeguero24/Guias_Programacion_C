package paquete;

import java.util.ArrayList;
import java.util.Random;

public class Donador implements Runnable {
    private Biblioteca biblioteca;
    private Random random = new Random();
    private ArrayList<String> titulos;

    public Donador(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        this.titulos = new ArrayList<>();
        cargaTitulos();
    }

    private void cargaTitulos() {
        this.titulos.add("El Aleph");
        this.titulos.add("Cien años de soledad");
        this.titulos.add("Pedro Paramo");
        this.titulos.add("La tregua");
        this.titulos.add("Facundo");
        this.titulos.add("Los siete locos");
        this.titulos.add("Bestiario");
        this.titulos.add("Boquitas pintadas");
        this.titulos.add("Operacion masacre");
        this.titulos.add("El beso de la mujer araña");
    }

    @Override
    public void run() {
        try{
            while(!this.titulos.isEmpty()){
                Thread.sleep(random.nextInt(2000));
                int id = random.nextInt(this.titulos.size());
                this.biblioteca.donar(this.titulos.remove(id));
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
