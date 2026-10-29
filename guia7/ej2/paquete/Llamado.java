package paquete;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Llamado implements Comparable<Llamado> {

    private GregorianCalendar fechahoraAtendido;
    private GregorianCalendar FechahoraPedido;
    private int prioridad;
    private Socio socio;

    public Llamado(int prioridad, Socio socio) {
        this.prioridad = prioridad;
        this.socio = socio;
        this.FechahoraPedido = new GregorianCalendar();
        this.fechahoraAtendido = null;
    }


    public GregorianCalendar getFechahoraAtendido() {
        return fechahoraAtendido;
    }

    public void setFechahoraAtendido(GregorianCalendar fechahoraAtendido) {
        this.fechahoraAtendido = fechahoraAtendido;
    }

    public GregorianCalendar getFechahoraPedido() {
        return FechahoraPedido;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public Socio getSocio() {
        return socio;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String pedidoStr = (FechahoraPedido != null) ? sdf.format(FechahoraPedido.getTime()) : "Pendiente";
        String atendidoStr = (fechahoraAtendido != null) ? sdf.format(fechahoraAtendido.getTime()) : "Sin atender";

        return "Llamado [" +
                "Prioridad: " + prioridad +
                " | Pedido: " + pedidoStr +
                " | Atendido: " + atendidoStr +
                " | Socio: " + socio.getNombre() + " (DNI: " + socio.getDni() + ")" +
                " | Domicilio: " + socio.getDomicilio() + "]";
    }

    @Override
    public int compareTo(Llamado o) {
        int rta=0;
        if (this.prioridad > o.prioridad) {
            rta = -1;
        }else if (this.prioridad < o.prioridad) {
            rta = 1;
        }else{
            rta = this.FechahoraPedido.compareTo(o.FechahoraPedido);
        }
        return rta;
    }
}
