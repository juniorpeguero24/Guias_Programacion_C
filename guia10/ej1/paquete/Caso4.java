package paquete;

public class Caso4 {
    private int trenesEnVia = 0;
    private int direccionActual = 0;
    private int esperandoDir1 = 0;
    private int esperandoDir2 = 0;

    public synchronized void entrar(int idTren,int dir) {
        if (dir == 1) {
            this.esperandoDir1++;
        }else{
            this.esperandoDir2++;
        }
        while ((this.trenesEnVia > 0 && this.direccionActual != dir)
                || (dir == 1 && this.esperandoDir2 > 0 && this.trenesEnVia > 0)
                || (dir == 2 && this.esperandoDir1 > 0 && this.trenesEnVia > 0)) {
            try{
                System.out.println("Tren " + idTren + " (Dir " + dir + ") esperando paso...");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        if (dir == 1) {
            this.esperandoDir1--;
        }else {
            this.esperandoDir2--;
        }
        if (this.trenesEnVia == 0) {
            this.direccionActual = dir;
        }
        this.trenesEnVia++;
        System.out.println("--> Tren " + idTren + " (Dir " + dir + ") ENTRÓ. [Trenes en vía: " + this.trenesEnVia + "]");
    }
    public synchronized void salir(int idTren,int dir) {
        this.trenesEnVia--;
        System.out.println("<-- Tren " + idTren + " (Dir " + dir + ") SALIÓ. [Trenes restantes en vía: " + this.trenesEnVia + "]");
        if (this.trenesEnVia == 0) {
            this.direccionActual = 0;
        }
        notifyAll();
    }
}
