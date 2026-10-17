package modelo;

public class Jugador {
    private String nombre;
    private int aciertos;
    
    public Jugador(String nombre){
        this.nombre=nombre;
        this.aciertos=0;
    }
    
    public void acierto(){
        this.aciertos++;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAciertos() {
        return aciertos;
    }
    
    @Override
    public String toString(){
        return this.nombre + " (" + this.aciertos + " aciertos)\n";
    }
}
