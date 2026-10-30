package paquete;

public class Main {
    public static void main(String[] args) {
        Mostrador mostrador = new Mostrador(4);
        for (int i = 0; i < 4; i++) {
            Thread t = new Thread(new Persona(mostrador), "Persona-" + i);
            t.start();
        }
    }
}
