package modelo;

import java.util.ArrayList;

public class Memotest {
    private Tablero tablero;
    private ArrayList<Jugador> jugadores;
    private int turnoActual = 0;
    
    public Memotest(Tablero tablero) {
        this.tablero = tablero;
        this.jugadores=new ArrayList<>();
    }
    
    public Jugador getJugadorActual(){
        return this.jugadores.get(this.turnoActual);
    }
    
    public void sumarAcierto() {
        this.getJugadorActual().acierto();
    }

    public void avanzaTurno() {
        this.turnoActual = (this.turnoActual + 1) % this.jugadores.size();
    }

    public void agregar(Jugador j) {
        this.jugadores.add(j);
    }


    public Tablero getTablero() {
        return tablero;
    }

    public ArrayList<Jugador> getArreglo() {
        return jugadores;
    }
}
