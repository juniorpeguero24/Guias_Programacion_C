package paquete;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Mesa mesa = new Mesa(4);
        Thread[] hilos = new Thread[4];
        for (int i = 0; i < 4; i++) {
            hilos[i] = new Thread(new Persona(mesa));
            hilos[i].start();
        }
        for (Thread h : hilos) {
            h.join();
        }
        mesa.mostrarResultados();
    }
}
