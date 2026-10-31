package paquete;

import java.util.ArrayList;
import java.util.Collections;

public class Mesa {
    private int turnoActual=0;
    private final int cantPersonas;
    private boolean juegoTerminado=false;
    private ArrayList<Integer> cartas;
    private int[] puntajes;
    private int[] victorias;
    private boolean rondaAnulada=false;

    public Mesa(int cantPersonas) {
        this.cantPersonas = cantPersonas;
        this.cartas = new ArrayList<>();
        this.puntajes = new int[cantPersonas];
        this.victorias = new int[cantPersonas];
        iniciaMazo();
    }

    private void iniciaMazo() {
        for(int v=1; v <= 9 ;v++){
            for (int c = 0; c < 4; c++) {
                this.cartas.add(v);
            }
        }
        for (int c = 0; c < 16; c++) {
            this.cartas.add(10);
        }
        Collections.shuffle(this.cartas);
    }

    public synchronized boolean atender(int turno) throws InterruptedException {
        while (turnoActual != turno && !juegoTerminado) {
            wait();
        }
        if (juegoTerminado) {
            return false;
        }
        System.out.println("Jugador " + turno + " esta jugando.");
        jugarTurno(turno);
        return true;
    }

    private void jugarTurno(int id) {
        int puntaje = 0;
        while (!this.cartas.isEmpty() && puntaje < 16) {
            puntaje += this.cartas.remove(0);
        }
        boolean seplanto = puntaje >= 16;
        this.puntajes[id] = (puntaje > 21) ? -1 : puntaje;

        if (this.cartas.isEmpty()) {
            this.juegoTerminado = true;
            if (!seplanto || id != this.cantPersonas - 1) {
                this.rondaAnulada = true;
            }
        }
    }

    public synchronized void despachar(int turno) {
        System.out.println("Jugador " + turno + " termino su turno.");
        if (this.rondaAnulada) {
            System.out.println("No alcanzaron las cartas, ronda anulada");
        }else if (turno == this.cantPersonas - 1) {
            ganador();
        }
        this.turnoActual = (this.turnoActual+1)%this.cantPersonas;
        notifyAll();
    }

    private void ganador() {
        int max=-1;
        int idMax = -1;
        boolean empate = false;

        for (int i = 0; i < this.cantPersonas; i++) {
            if (this.puntajes[i] > max) {
                max = this.puntajes[i];
                idMax = i;
                empate = false;
            } else if (this.puntajes[i] == max) {
                empate = true;
            }
        }
        if (!empate && max > 0) {
            this.victorias[idMax]++;
            System.out.println(">> Gana la mano el jugador "+idMax+" con "+max);
        }else{
            System.out.println(">> Mano sin ganador");
        }
    }

    public synchronized void mostrarResultados() {
        int max = -1, idMax = -1;
        boolean empate = false;
        for (int i = 0; i < this.cantPersonas; i++) {
            System.out.println("Jugador " + i + ": " + victorias[i] + " manos ganadas");
            if (victorias[i] > max) {
                max = victorias[i];
                idMax = i;
                empate = false;
            } else if (victorias[i] == max) {
                empate = true;
            }
        }
        System.out.println(empate ? "Empate general" : "Ganador: jugador " + idMax);
    }

    public int getCantPersonas() {
        return cantPersonas;
    }
}
