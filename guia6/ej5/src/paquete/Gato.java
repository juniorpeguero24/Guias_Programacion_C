package paquete;

public class Gato extends Animal{
    public Gato(String nombre,int i){
        super(nombre,i);
    }

    public Gato() {
        super();
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException{
        throw new CloneNotSupportedException("Los gatos no son cloneables");
    }
    
    @Override
    public String toString(){
        return "Gato "+super.toString();
    }
}
