package paquete;

import java.util.GregorianCalendar;

public class Archivo extends Elemento {
    private GregorianCalendar fechaModificacion;
    private double tamaño;

    public Archivo(String nombre, GregorianCalendar fechaCreacion, GregorianCalendar fechaModificacion, double tamaño) {
        super(nombre, fechaCreacion);
        this.fechaModificacion = fechaModificacion;
        this.tamaño = tamaño;
    }

    public GregorianCalendar getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(GregorianCalendar fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @Override
    public double getTamaño() {
        return tamaño;
    }

    @Override
    public void listar(String prefijo) {
        System.out.println(prefijo + "- " + getNombre() + " (" + tamaño + " kb)");
    }
}