package paquete;

public class Perro extends Animal implements Cloneable {
    public Perro(String nombre,int i) {
        super(nombre,i);
    }

    public Perro() {
        super();
    }
    
    @Override
    public String toString(){
        return "Perro "+super.toString();
    }
}
