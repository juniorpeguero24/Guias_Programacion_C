package paquete;

public class Numero {
    private int dato;


    public Numero(int dato) {
        this.dato = dato;
    }
    
    public void setDato(int dato){
        this.dato=dato;
    }

    public int getDato() {
        return dato;
    }

    @Override
    public String toString() {
        return ""+this.dato;
    }
}
