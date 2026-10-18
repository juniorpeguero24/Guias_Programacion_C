package vista;

import controlador.ControladorEstacion;

import javax.swing.*;

public class DialogCrear extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtCombustible;
    private JTextField txtCantMax;
    private JButton agregarButton;
    private JTextField txtPrecio;

    public DialogCrear() {
    }

    public void setControlador(ControladorEstacion c) {
        this.agregarButton.addActionListener(c);
        this.buttonOK.addActionListener(c);
    }

    public void arranca() {
        setContentPane(contentPane);
        pack();
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setVisible(true);
    }

    public String getTxtCombustible() {
        return this.txtCombustible.getText().trim();
    }

    public int getCantidadMaxima() {
        return Integer.parseInt(this.txtCantMax.getText().trim());
    }

    public Double getTxtPrecio() {
        return Double.parseDouble(this.txtPrecio.getText().trim());
    }

    public void limpiaCampos() {
        this.txtCantMax.setText("");
        this.txtCombustible.setText("");
        this.txtPrecio.setText("");
        this.txtCombustible.requestFocus();
    }
}
