package vista;

import controlador.Controlador;
import paquete.Pedido;
import paquete.Producto;
import paquete.Proveedor;

import javax.swing.*;
import java.util.ArrayList;

public class Vista extends JFrame {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JButton guardarBINButton;
    private JButton guardarXMLButton;
    private JButton cargarBINButton;
    private JButton cargarXMLButton;
    private JList<Proveedor> listProovedores;
    private JList<Producto> listProductos;
    private JList<Pedido> listPedidos;
    private JList<Proveedor> listDeudores;
    private DefaultListModel<Proveedor> modeloVistaProveedores;
    private DefaultListModel<Producto> modeloVistaProducto;
    private DefaultListModel<Pedido> modeloVistaPedido;
    private DefaultListModel<Proveedor> modeloVistaDeudores;

    public Vista() {
        modeloVistaPedido = new DefaultListModel<>();
        modeloVistaProducto = new DefaultListModel<>();
        modeloVistaProveedores  = new DefaultListModel<>();
        modeloVistaDeudores = new DefaultListModel<>();
        listProovedores.setModel(modeloVistaProveedores);
        listDeudores.setModel(modeloVistaDeudores);
        listPedidos.setModel(modeloVistaPedido);
        listProductos.setModel(modeloVistaProducto);
    }

    public void arranca() {
        setContentPane(panel1);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void setControlador(Controlador c) {
        guardarBINButton.addActionListener(c);
        guardarXMLButton.addActionListener(c);
        cargarBINButton.addActionListener(c);
        cargarXMLButton.addActionListener(c);
    }

    public void aviso(String s) {
        JOptionPane.showMessageDialog(this, s, "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }

    public void listarProveedores(ArrayList<Proveedor> proveedores) {
        modeloVistaProveedores.clear();
        for (Proveedor p : proveedores) {
            modeloVistaProveedores.addElement(p);
        }
    }

    public void listarProductos(ArrayList<Producto> productos) {
        modeloVistaProducto.clear();
        for (Producto p : productos) {
            modeloVistaProducto.addElement(p);
        }
    }

    public void listarPedidosNoEntregados(ArrayList<Pedido> pedidosNoEntregados) {
        modeloVistaPedido.clear();
        for (Pedido p : pedidosNoEntregados) {
            modeloVistaPedido.addElement(p);
        }
    }

    public void listarDeudores(ArrayList<Proveedor> proveedoresQueAdeudan) {
        modeloVistaDeudores.clear();
        for (Proveedor p : proveedoresQueAdeudan) {
            modeloVistaDeudores.addElement(p);
        }
    }
}
