package vista;

import javax.swing.*;

public class VistaPrincipal extends JFrame {
    private JPanel panel1;
    private JTextArea txtAreaInforme;

    public void arranca() {
        setContentPane(panel1);
        txtAreaInforme.setEditable(false);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void informar(String s) {
        // Se puede llamar desde cualquier hilo: el append se ejecuta en el hilo de Swing
        SwingUtilities.invokeLater(() -> txtAreaInforme.append(s + "\n"));
    }
}