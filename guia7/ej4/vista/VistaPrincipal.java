package vista;

import paquete.Controlador;
import paquete.Producto;

import javax.swing.*;
import java.util.ArrayList;

public class VistaPrincipal extends JFrame{
    private JPanel panel1;
    private JTextArea txtAreaDetalle;
    private JSpinner spinner1;
    private JComboBox<Producto> cmbProducto;
    private JButton agregarButton;
    private JButton eliminarButton;
    private JButton detalleButton;
    private JButton precioTotalButton;
    private JTextArea txtAreaInfo;

    public void setControlador(Controlador c){
        this.agregarButton.addActionListener(c);
        this.eliminarButton.addActionListener(c);
        this.detalleButton.addActionListener(c);
        this.precioTotalButton.addActionListener(c);
    }

    public void arranca() {

    }

    public void cargarProductosCombo(ArrayList<Producto> catalogo) {
        for (Producto p : catalogo) {
            this.cmbProducto.addItem(p);
        }
    }

    public int getCantidad(){
        return Integer.parseInt(this.spinner1.toString());
    }

    public Producto getProductoSeleccionado() {
        return (Producto) this.cmbProducto.getSelectedItem();
    }

    public void mensaje(String s) {
        this.txtAreaInfo.append("\n"+s+"\n");
    }
}
