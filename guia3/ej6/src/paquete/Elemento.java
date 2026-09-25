package paquete;

import java.util.GregorianCalendar;

public abstract class Elemento {
    private String nombre;
    private GregorianCalendar fecha;

    public Elemento(String nombre, GregorianCalendar fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    public abstract double getTamaño();
    public abstract void listar(String prefijo);
}