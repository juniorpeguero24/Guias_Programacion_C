package paquete;

public class Caso1 {
    private boolean ocupado = false;

    public synchronized void entrar(int idTren) {
        while (this.ocupado) {
            try{
                System.out.println("Tren "+idTren+" esperando: la vida esta ocupada.");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        this.ocupado = true;
        System.out.println("--> Tren: " + idTren + " Entro al tramo compartido.");
    }

    public synchronized void salir(int idTren) {
        this.ocupado = false;
        System.out.println("<-- Tren " + idTren + " Salio del tramo compartido.");
        notifyAll();
    }
}
