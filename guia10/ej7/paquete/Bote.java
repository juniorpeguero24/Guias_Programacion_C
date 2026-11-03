package paquete;

public class Bote {
    private static final int CAPACIDAD = 5;
    private final int totalPersonas;

    private int cant = 0;                       // pasajeros a bordo
    private final int[] esperando = new int[2]; // esperando[0] = orilla A, esperando[1] = orilla B
    private int orilla = 0;                     // 0 = A, 1 = B
    private boolean cruzando = false;
    private boolean bajando = false;
    private int cruzaron = 0;                   // personas que ya llegaron a destino

    public Bote(int totalPersonas) {
        this.totalPersonas = totalPersonas;
    }

    private String nombre(int o) {
        return o == 0 ? "A" : "B";
    }

    // ======================= PERSONAS =======================

    public synchronized void subir(Persona p) throws InterruptedException {
        esperando[p.getOrilla()]++;                       // la persona llega y empieza a esperar
        System.out.println(p.getNombre() + " llega a la orilla " + nombre(p.getOrilla()));
        notifyAll();                                      // el barquero puede estar esperando gente

        while (orilla != p.getOrilla() || cant == CAPACIDAD || cruzando || bajando) {
            wait();
        }
        esperando[p.getOrilla()]--;                       // deja de esperar...
        cant++;                                           // ...y pasa a estar arriba
        System.out.println("   Se subio " + p.getNombre() + " en " + nombre(orilla) + " (" + cant + "/" + CAPACIDAD + ")");
        notifyAll();                                      // puede habilitar que el barquero zarpe
    }

    public synchronized void bajar(Persona p) throws InterruptedException {
        while (!bajando) {
            wait();
        }
        cant--;
        cruzaron++;
        p.setOrilla(orilla);
        System.out.println("   Se bajo " + p.getNombre() + " en " + nombre(orilla));
        if (cant == 0) {
            bajando = false;                              // bote vacío: ya pueden subir los de esta orilla
        }
        notifyAll();
    }

    // ======================= BARQUERO =======================

    private boolean puedeZarpar() {
        if (cruzando || bajando) return false;
        if (cant == CAPACIDAD) return true;               // caso 1: lleno
        int otra = 1 - orilla;
        // caso 2: nadie más esperando acá, y el viaje tiene sentido
        // (lleva a alguien, o hay gente esperando del otro lado)
        return esperando[orilla] == 0 && (cant > 0 || esperando[otra] > 0);
    }

    /** Devuelve false cuando ya cruzaron todos y el barquero puede irse. */
    public synchronized boolean zarpar() throws InterruptedException {
        while (cruzaron < totalPersonas && !puedeZarpar()) {
            wait();
        }
        if (cruzaron == totalPersonas) {
            return false;
        }
        cruzando = true;
        System.out.println("El bote zarpa de " + nombre(orilla) + " con " + cant + " pasajero(s)");
        return true;
    }

    public synchronized void llegar() {
        orilla = 1 - orilla;
        cruzando = false;
        bajando = cant > 0;                               // si llegó vacío, no hay nadie que bajar
        System.out.println("El bote llega a " + nombre(orilla));
        notifyAll();
    }
}