package vista;

import controlador.ControladorMemotest;
import modelo.Jugador;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class DialogJugadores extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtNombre;
    private JButton agregarButton;
    private JList<String> listJugadores;
    private DefaultListModel<String> modeloJugadores;

    public DialogJugadores() {
        getRootPane().setDefaultButton(buttonOK);

        this.modeloJugadores = new DefaultListModel<>();
        this.listJugadores.setModel(this.modeloJugadores);
    }

    public String getNombre() {
        return this.txtNombre.getText().trim();
    }

    public void setControlador(ControladorMemotest controlador) {
        this.buttonOK.addActionListener(controlador);
        this.buttonCancel.addActionListener(controlador);
        this.agregarButton.addActionListener(controlador);
    }

    public void actualizarLista(ArrayList<Jugador> jugadores) {

    }

    public void arranca() {
        setContentPane(contentPane);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void errorOk(String s, String aviso) {
        JOptionPane.showMessageDialog(this,s,aviso,JOptionPane.WARNING_MESSAGE);
    }

    public void actualizarListaNombres(ArrayList<String> nombresJugadores) {
        this.modeloJugadores.clear();
        for (String n : nombresJugadores) {
            this.modeloJugadores.addElement(n);
        }
        this.listJugadores.repaint();
    }
}
