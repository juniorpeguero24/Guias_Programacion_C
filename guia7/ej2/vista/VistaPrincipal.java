package vista;

import paquete.Controlador;
import paquete.Llamado;

import javax.swing.*;

public class VistaPrincipal extends JFrame{
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

    public void arranca() {
        setContentPane(this.panel1);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        this.txtAreaInfo.setLineWrap(true);
        this.txtAreaInfo.setWrapStyleWord(true);
    }

    public int getDni(){
        return Integer.parseInt(this.txtDni.getText());
    }

    public String getNombre(){
        return this.txtNombre.getText();
    }

    public String getDomicilio(){
        return this.txtDomicilio.getText();
    }

    public int  getPrioridad(){
        return (int) this.spinPrioridad.getValue();
    }

    public void actualizaCont(int cantidad) {
        this.labelCantLlamados.setText("Llamados en espera: "+cantidad);
    }

    public void mostrarLlamadoAtendido(Llamado llamado) {
        this.txtAreaInfo.append(llamado.toString()+"\n\n");
    }

    public void muestraError(String s) {
        JOptionPane.showMessageDialog(this, s, "Error", JOptionPane.WARNING_MESSAGE);
    }
}
