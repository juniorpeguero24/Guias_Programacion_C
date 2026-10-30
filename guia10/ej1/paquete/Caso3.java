package paquete;

public class Caso3 {
    private boolean ocupado;
    private int trenesEnVia = 0;
    private int direccionActual=0;

    public synchronized void entrar(int idTren,int dir) {
        while (this.trenesEnVia > 0 && this.direccionActual != dir) {
            try{
                System.out.println("Tren " + idTren + " (Dir " + dir + ") esperando: la via esta ocupada por trenes en sentido opuesto.");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        if (this.trenesEnVia==0) {
            this.direccionActual = dir;
        }
        this.trenesEnVia++;
        System.out.println("--> Tren " + idTren + " (Dir " + dir + ") ENTRO. [Trenes en via: " + this.trenesEnVia + "]");
    }

    public synchronized void salir(int idTren, int dir) {
        this.trenesEnVia--;
        System.out.println("<-- Tren " + idTren + " (Dir " + dir + ") SALIÓ. [Trenes restantes en vía: " + this.trenesEnVia + "]");
        if (this.trenesEnVia == 0) {
            this.direccionActual = 0;
            notifyAll();
        }
    }
}
