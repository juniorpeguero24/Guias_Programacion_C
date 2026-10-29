package vista;

import paquete.Controlador;

import javax.swing.*;
import java.util.Iterator;

public class VistaPrincipal extends JFrame {
    private JPanel panel1;
    private JTextField txtApellido;
    private JTextField txtNombre;
    private JTextField txtDomicilio;
    private JButton agregarButton;
    private JLabel labelCardinal;
    private JButton eliminarButton;
    private JList listConjunto;
    private JButton consultarButton;
    private DefaultListModel modeloVista;

    public VistaPrincipal() {
        this.modeloVista = new DefaultListModel<>();
    }

    public void setControlador(Controlador c) {
        this.agregarButton.addActionListener(c);
        this.eliminarButton.addActionListener(c);
        this.consultarButton.addActionListener(c);
    }

    public String getTxtApellido() {
        return txtApellido.getText();
    }

    public String getTxtNombre() {
        return txtNombre.getText();
    }

    public String getTxtDomicilio() {
        return txtDomicilio.getText();
    }

    public void arranca() {
        setContentPane(this.panel1);
        this.listConjunto.setModel(modeloVista);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public Object getElemento() {
        return this.listConjunto.getSelectedValue();
    }

    public void muestraError(String message, Object elemento) {
        JOptionPane.showMessageDialog(this,message+"\n"+elemento.toString(),"Error",JOptionPane.WARNING_MESSAGE);
    }

    public void actualizarLista(Iterator iterator) {
        this.modeloVista.clear();
        while (iterator.hasNext()) {
            this.modeloVista.addElement(iterator.next());
        }
    }

    public void actualizarCardinal(int cardinal) {
        this.labelCardinal.setText("Cantidad de elementos: "+cardinal);
    }
}
