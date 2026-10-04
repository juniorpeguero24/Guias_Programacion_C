package paquete;

import java.util.ArrayList;

public class Universo {
    private ArrayList<Personaje> personajes ;

    public Universo() {
        this.personajes = new ArrayList<>();
    }

    public void agregarPersonaje(Personaje p) {
        this.personajes.add(p);
    }

    public void eliminarPersonaje(Personaje p) {
        this.personajes.remove(p);
    }

    public ArrayList<Personaje> getPersonajes() {
        return personajes;
    }
}
