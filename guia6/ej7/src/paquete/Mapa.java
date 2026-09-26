package paquete;

import excepciones.AtaqueImposibleException;

import excepciones.IncrementoImposibleException;

import java.util.ArrayList;

public class Mapa implements Cloneable{
    private static Mapa instance=null;
    private ArrayList<Personaje> personajes;
    
    private Mapa() {
        personajes= new ArrayList<>();
    }
    
    public static Mapa getInstance(){
        if (instance == null)
            instance = new Mapa();
        return instance;
    }
    
    public void mueve(Personaje p, double X,double Y){
        try {
            p.incrementaPos(X, Y);
        } catch (IncrementoImposibleException e) {
            double factor= e.getMaxDistanciaSoportada()/e.getDistanciaPretendida();
            try {
                p.incrementaPos(X * factor, Y * factor);
            } catch (IncrementoImposibleException f) {
            }
        }
    }
    
    public void ataca(Personaje atacante,Personaje atacado) throws AtaqueImposibleException {
        atacante.ataca(atacado);
    }
    
    public void agregarPersonaje(Personaje p){
        this.personajes.add(p);        
    }
    
    public void eliminarPersonaje(Personaje p){
        this.personajes.remove(p);
    }


    public ArrayList<Personaje> getPersonajes() {
        return personajes;
    }


    // Lo que se hace en la práctica real con un Singleton:
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Un Singleton no puede ser clonado.");
    }
}
