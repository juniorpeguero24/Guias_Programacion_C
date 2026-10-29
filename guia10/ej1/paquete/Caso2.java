package paquete;

public class Caso2 {
    private boolean ocupado=false;
    private int esperandoDir1 = 0;
    private int esperandoDir2 = 0;
    private int turnoDireccion=1;

    public synchronized void entrar(int idTren, int dir) {
        if (dir == 1) {
            this.esperandoDir1++;
        } else {
            this.esperandoDir2++;
        }
        while (this.ocupado || (dir == 1 && this.turnoDireccion == 2 && this.esperandoDir2 > 0)
                || (dir == 2 && this.turnoDireccion == 1 && this.esperandoDir1 > 0)) {
            try{
                System.out.println("Tren " + idTren + " (Dir " + dir + ") esperando paso...");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        if (dir == 1) {
            this.esperandoDir1--;
        } else {
            this.esperandoDir2--;
        }
        this.ocupado = true;
        System.out.println("--> Tren " + idTren + " (Dir " + dir + ") ENTRÓ a la vía.");
    }

    public synchronized void salir(int idTren,int dir) {
        this.ocupado = false;
        this.turnoDireccion = (dir == 1) ? 2:1;
        System.out.println("<-- Tren " + idTren + " (Dir " + dir + ") SALIÓ de la vía.");
        notifyAll();
    }
}
