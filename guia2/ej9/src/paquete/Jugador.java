package paquete;

public class Jugador {
    private String nombre;
    private int puntaje, pg, pe, pp;

    public Jugador(String nom) {
        this.nombre = nom;
        this.pg = this.pe = this.pp = this.puntaje = 0;
    }

    public int getPartidosJugados() {
        return pg + pe + pp;
    }

    public String getNombre() { return nombre; }
    public int getPuntaje() { return puntaje; }
    public void setPuntaje(int puntaje) { this.puntaje = puntaje; }
    public int getPg() { return pg; }
    public void setPg(int pg) { this.pg = pg; }
    public int getPe() { return pe; }
    public void setPe(int pe) { this.pe = pe; }
    public int getPp() { return pp; }
    public void setPp(int pp) { this.pp = pp; }

    @Override
    public String toString() {
        return nombre + " [Pts: " + puntaje + " | PJ: " + getPartidosJugados() + " (PG:" + pg + " PE:" + pe + " PP:" + pp + ")]";
    }
}