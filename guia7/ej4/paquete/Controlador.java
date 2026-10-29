package paquete;

import vista.VistaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controlador implements ActionListener {
    private VistaPrincipal vista;
    private Pedido modelo;

    public Controlador(VistaPrincipal vista, Pedido modelo, ArrayList<Producto> catalogo) {
        this.vista = vista;
        this.vista.cargarProductosCombo(catalogo);
        this.modelo = modelo;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("Agregar")) {
            try {
                int cant = this.vista.getCantidad();
                Producto producto=this.vista.getProductoSeleccionado();
                LineaDePedido lp = new LineaDePedido(cant, producto);
                this.modelo.agrega(lp);
                this.vista.mensaje("Se agrego con exito "+cant+" "+ producto.toString());
            } catch (OperacionConjuntosException ex) {
                this.vista.mensaje("No se pudo agregar "+ex.getElemento().toString());
            }
        } else if (cmd.equals("Eliminar")) {
            try {
                Producto producto=this.vista.getProductoSeleccionado();
                int cant = this.vista.getCantidad();
                this.modelo.elimina(new LineaDePedido(cant,producto));
                this.vista.mensaje("Se elimino con exito: "+producto);
            } catch (OperacionConjuntosException ex) {
                this.vista.mensaje("No se pudo eliminar "+ex.getElemento().toString());
            }
        }
    }
}
