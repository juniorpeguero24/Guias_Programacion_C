package paquete;

public class Main {
    public static void main(String[] args) {
        Mesa mesa = new Mesa(4);
        for (int i = 0; i < 4; i++) {
            Thread t = new Thread(new Persona(mesa), "Persona-" + i);
            t.start();
        }
    }
}
