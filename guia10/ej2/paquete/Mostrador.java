package paquete;

public class Mostrador {
    private int turnoActual=0;
    private final int cantPersonas;

    public Mostrador(int cantPersonas) {
        this.cantPersonas = cantPersonas;
    }

    public synchronized void atender(int turno) {
        while (turnoActual != turno) {
            try {
                System.out.println("Turno actual: "+this.turnoActual+" Turno de espera: "+turno);
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Turno " + turno + " siendo atendido.");
    }

    public synchronized void despachar(int turno) {
        this.turnoActual = (this.turnoActual+1)%this.cantPersonas;
        System.out.println("Turno " + turno + " salio del mostrador.");
        notifyAll();
    }

    public int getCantPersonas() {
        return cantPersonas;
    }
}
