package paquete;

import vista.VistaPrincipal;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Empleado emp = new Empleado("Juan Gomez");
        Pedido pedido = new Pedido(emp);

        ArrayList<Producto> catalogo = new ArrayList<>();
        catalogo.add(new Producto(101, "Cuaderno espiral A4", 4500.0));
        catalogo.add(new Producto(102, "Lapicera trazo fino azul", 850.0));
        catalogo.add(new Producto(103, "Resma A4 75g", 8200.0));
        catalogo.add(new Producto(104, "Marcador permanente negro", 1400.0));
        catalogo.add(new Producto(105, "Corrector líquido 20ml", 1200.0));

        VistaPrincipal vista = new VistaPrincipal();
        Controlador controlador = new Controlador(vista, pedido, catalogo);
        vista.setControlador(controlador);
        vista.arranca();
    }
}
