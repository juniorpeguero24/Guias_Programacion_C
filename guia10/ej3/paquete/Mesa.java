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

    public synchronized void atender(int turno) {
        while (turnoActual != turno && !juegoTerminado) {
            try {
                System.out.println("Turno actual: "+this.turnoActual+" Turno de espera: "+turno);
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Turno " + turno + " esta jugando.");
        jugarTurno(turno);
    }

    private void jugarTurno(int id) {
        int puntaje = 0;
        while (!this.cartas.isEmpty() && puntaje < 16) {
            puntaje += this.cartas.remove(0);
        }
        if (puntaje > 21) {
            this.puntajes[id] = -1;
        } else {
            this.puntajes[id] = puntaje;
        }
        if (this.cartas.isEmpty()) {
            this.juegoTerminado = true;
            if (id == (this.cantPersonas - 1)) {
                System.out.println("No alcanzaron las cartas, ronda anulada.");
                // Y aca finalizar todo no?
            }
        }
    }

    public synchronized void despachar(int turno) {
        if (turno == this.cantPersonas - 1) {
            ganador();
        }
        this.turnoActual = (this.turnoActual+1)%this.cantPersonas;
        System.out.println("Turno " + turno + " termino su turno.");
        notifyAll();
    }

    private void ganador() {
        int max=-111;
        int idMax = -1;
        boolean doble = false;

        for (int i = 0; i < this.cantPersonas; i++) {
            if (this.puntajes[i] > max) {
                max = this.puntajes[i];
                idMax = i;
                doble = false;
            } else if (this.puntajes[i] == max) {
                doble = true;
            }
        }
        if (!doble) {
            this.victorias[idMax]++;
        }
    }

    public int getCantPersonas() {
        return cantPersonas;
    }
}
