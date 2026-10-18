package vista;

import controlador.ControladorMemotest;
import modelo.Jugador;
import modelo.Memotest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VistaPrincipal extends JFrame {
    private JPanel panel1;
    private JPanel panelTablero;
    private JTextField txtAncho;
    private JTextField txtAlto;
    private JButton aceptarButton;
    private JList<Jugador> listJugadores;
    private JLabel labelTurnoActual;
    private DefaultListModel<Jugador> modeloJugador;
    private JButton[][] botones;

    public VistaPrincipal() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.aceptarButton.setEnabled(false);
        this.modeloJugador = new DefaultListModel<>();
        this.listJugadores.setModel(this.modeloJugador);
    }

    public void arranca(){
        this.setContentPane(panel1);
        pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void setTurnoActual(String nombre) {
        this.labelTurnoActual.setText("Turno Actual: " + nombre);
    }

    public void generarTablero(int i, int j, ActionListener listenerCasillas) {
        this.botones = new JButton[i][j];
        this.panelTablero.setLayout(new GridLayout(i, j));
        this.panelTablero.removeAll();
        for (int k = 0; k < i; k++) {
            for (int l = 0; l < j; l++) {
                JButton btn = new JButton();
                btn.setActionCommand(k + "," + l);
                btn.addActionListener(listenerCasillas);
                this.botones[k][l] = btn;
                this.panelTablero.add(btn);
            }
        }
        this.panelTablero.revalidate();
        this.panelTablero.repaint();
        this.pack();
    }

    public void mostrarFigura(int i, int j, int idFigura) {
        String ruta = "64/" + idFigura + "_64px.png";
        java.io.File archivo = new java.io.File(ruta);
        System.out.println(archivo.getAbsolutePath() + " -> " + archivo.exists());
        ImageIcon icono = new ImageIcon(ruta);
        this.botones[i][j].setIcon(icono);
    }

    public void taparFigura(int i, int j) {
        this.botones[i][j].setIcon(null);
    }

    public void deshabilitarCasilla(int i, int j) {
        this.botones[i][j].setEnabled(false);
    }


    public void setAceptarEnabled(boolean b) {
        this.aceptarButton.setEnabled(b);
    }

    public String getTxtAlto() {
        return this.txtAlto.getText();
    }

    public String getTxtAncho() {
        return this.txtAncho.getText();
    }

    public void setControlador(ControladorMemotest c) {
        this.txtAlto.addKeyListener(c);
        this.txtAncho.addKeyListener(c);
        this.aceptarButton.addActionListener(c);
    }

    public void actualizarLista(ArrayList<Jugador> jugadores) {
        this.modeloJugador.clear();
        for (Jugador j : jugadores) {
            this.modeloJugador.addElement(j);
        }
        this.listJugadores.repaint();
    }

    public void ganador(String ganador) {
        JOptionPane.showMessageDialog(this, "Ganador: " + ganador, "FIN",JOptionPane.INFORMATION_MESSAGE);
    }
}
