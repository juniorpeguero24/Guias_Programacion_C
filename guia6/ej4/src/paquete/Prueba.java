package paquete;

public class Prueba {
    public static void main(String[] args) {
        ConjuntoNumeros c1 = new ConjuntoNumeros("Conjunto 1",5);
        c1.getCelda()[0].setDato(10);
        c1.getCelda()[1].setDato(20);
        c1.getCelda()[2].setDato(30);
        c1.getCelda()[3].setDato(40);
        c1.getCelda()[4].setDato(50);
        
        ConjuntoNumeros c2 = (ConjuntoNumeros)c1.clone();
        
        c2.getCelda()[0].setDato(99);
        
        System.out.println(c1.toString());
        System.out.println(c2.toString());
    }
}
