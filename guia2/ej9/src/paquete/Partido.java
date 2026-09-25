package paquete;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Partido {
    private Equipo eq1, eq2;
    private GregorianCalendar fecha;
    private int r1, r2;

    public Partido(GregorianCalendar fecha) {
        this.eq1 = new Equipo();
        this.eq2 = new Equipo();
        this.fecha = fecha;
        this.r1 = 0;
        this.r2 = 0;
    }

    public boolean agregarJugador(Jugador j, int numEquipo) {
        // Validación: Un jugador no puede estar en ambos equipos
        if (eq1.contieneJugador(j.getNombre()) || eq2.contieneJugador(j.getNombre())) {
            return false;
        }
        if (numEquipo == 1) eq1.agregarJugador(j);
        else eq2.agregarJugador(j);
        return true;
    }

    public boolean esValidoParaJugar() {
        // Restricción: Mínimo 4 jugadores por equipo
        return eq1.cantidadJugadores() >= 4 && eq2.cantidadJugadores() >= 4;
    }

    public String getFechaFormateada() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEEE dd 'de' MMMMMMMMM 'de' yyyy");
        return sdf.format(fecha.getTime());
    }

    public Equipo getEq1() { return eq1; }
    public Equipo getEq2() { return eq2; }
    public int getR1() { return r1; }
    public int getR2() { return r2; }
    public void setResultado(int r1, int r2) {
        this.r1 = r1;
        this.r2 = r2;
    }
}