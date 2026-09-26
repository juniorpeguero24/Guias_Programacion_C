package paquete;

public class Animal implements Cloneable{
    private int esperanzadevida;
    private String nombre;

    public Animal(){}

    public Animal(String nombre,int esperanzadevida) {
        this.esperanzadevida = esperanzadevida;
        this.nombre = nombre;
    }


    @Override
    public String toString() {
        return "Nombre: "+nombre+" Esperanza de vida: "+esperanzadevida;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public void setEsperanzadevida(int esperanzadevida) {
        this.esperanzadevida = esperanzadevida;
    }

    public int getEsperanzadevida() {
        return esperanzadevida;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
