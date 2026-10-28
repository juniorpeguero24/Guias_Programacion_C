package vista;

import paquete.Controlador;

import javax.swing.*;

public class vistaPrincipal extends JFrame{
    private JPanel panel1;
    private JTextField txtDni;
    private JTextField txtNombre;
    private JTextField txtDomicilio;
    private JSpinner spinPrioridad;
    private JButton ingresarLlamadoButton;
    private JButton btnAtenderLlamado;
    private JLabel labelCantLlamados;
    private JTextArea txtAreaInfo;

    public void setControlador(Controlador c) {
        this.btnAtenderLlamado.addActionListener(c);
        this.ingresarLlamadoButton.addActionListener(c);
    }

    public void arranca(){
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public String getDni(){
        return this.txtDni.getText();
    }

    public String getNombre(){
        return this.txtNombre.getText();
    }

    public String getDomicilio(){
        return this.txtDomicilio.getText();
    }
}
