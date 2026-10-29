package paquete;

public class Main {
    public static void main(String[] args) {
//        Caso1 via = new Caso1();
//        for (int i = 1; i <= 5; i++) {
//            Thread t = new Thread(new Tren(i, via));
//            t.start();
//        }

        Caso2 via2 = new Caso2();
        Thread[] trenes = new Thread[6];
        trenes[0] = new Thread(new TrenC2(1, 1, via2), "Tren-1-Dir1");
        trenes[1] = new Thread(new TrenC2(2, 1, via2), "Tren-2-Dir1");
        trenes[2] = new Thread(new TrenC2(3, 1, via2), "Tren-3-Dir1");
        trenes[3] = new Thread(new TrenC2(4, 2, via2), "Tren-4-Dir2");
        trenes[4] = new Thread(new TrenC2(5, 2, via2), "Tren-5-Dir2");
        trenes[5] = new Thread(new TrenC2(6, 2, via2), "Tren-6-Dir2");
        for (Thread t : trenes) {
            t.start();
        }
    }
}