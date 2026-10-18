package vista;

import controlador.ControladorEstacion;
import exception.DatoCargaInvalido;
import modelo.Deposito;
import modelo.Surtidor;

import javax.swing.*;
import java.util.HashMap;

public class VistaPrincipal extends JFrame{
    private JPanel panel1;
    private JButton crearSurtidorButton;
    private JList<Surtidor> listSurtidores;
    private JButton reponerButton;
    private JTextField txtCantidad;
    private JButton cargarButton;
    private JComboBox<Deposito> cmbCombustible;
    private JLabel labelCombustible;
    private DefaultListModel<Surtidor> modeloSurtidores;

    public VistaPrincipal() {
        this.modeloSurtidores = new DefaultListModel<>();
        this.listSurtidores.setModel(modeloSurtidores);
        this.cmbCombustible.setEnabled(false);
        this.labelCombustible.setEnabled(false);

    }

    public void setControlador(ControladorEstacion c) {
        this.crearSurtidorButton.addActionListener(c);
        this.reponerButton.addActionListener(c);
        this.cargarButton.addActionListener(c);
        this.listSurtidores.addListSelectionListener(c);
    }

    public void actualizarSurtidores(HashMap<Integer, Surtidor> surtidores) {
        this.modeloSurtidores.clear();
        for (Surtidor s: surtidores.values()) {
            this.modeloSurtidores.addElement(s);
        }
        this.listSurtidores.repaint();
    }

    public Surtidor getSelectedSurtidor() {
        return this.listSurtidores.getSelectedValue();
    }

    public int getTxtCantidad() {
        return Integer.parseInt(this.txtCantidad.getText().trim());
    }

    public void mensajeErrorFaltaCombustible(DatoCargaInvalido dato) {
        JOptionPane.showMessageDialog(this,"Falta " + dato.getCombustible() +
                ".\nSe tiene " + dato.getDisponible() + " se requiere " + dato.getCantidad(),"Error",JOptionPane.WARNING_MESSAGE);
    }

    public void errorCantidadNegativa(String cantidadNegativa) {
        JOptionPane.showMessageDialog(this, cantidadNegativa, "Error", JOptionPane.WARNING_MESSAGE);
    }

    public void habilitarCombustible(boolean b) {
        this.cmbCombustible.setEnabled(b);
        this.labelCombustible.setEnabled(b);
    }

    public void cargarComboCombustible(HashMap<String, Deposito> depositos) {
        this.cmbCombustible.removeAllItems();
        for (Deposito d : depositos.values()) {
            this.cmbCombustible.addItem(d);
        }
    }

    public Deposito getSelectedCombustible() {
        return (Deposito) this.cmbCombustible.getSelectedItem();
    }

    public void arranca() {
        setContentPane(this.panel1);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
