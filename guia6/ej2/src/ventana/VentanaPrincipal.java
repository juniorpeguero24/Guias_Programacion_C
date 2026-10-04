package ventana;

import excepciones.DatoInvalido;
import excepciones.DepositoInvalidoException;
import excepciones.ExtraccionInvalidadException;
import excepciones.TitularInvalidoException;
import paquete.CuentaBancaria;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame{
    private JPanel panel1;
    private JTextArea txtDescripcion;
    private JTextArea txtCuenta;
    private JTextField txtNombre;
    private JButton crearButton;
    private JTextField txtMonto;
    private JButton extraerButton;
    private JButton depositarButton;
    private CuentaBancaria cuenta;

    public VentanaPrincipal(){
        setContentPane(panel1);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Cuenta Bancaria");
        setLocationRelativeTo(null);

        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText().trim();
                try {
                    cuenta = new CuentaBancaria(nombre);
                    txtDescripcion.append("\nCuenta de "+nombre+" creada con exito.");
                    actualizarCuenta();
                } catch (TitularInvalidoException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al crear la cuenta", JOptionPane.ERROR_MESSAGE);
                    txtDescripcion.append("\n" + ex.getMessage());
                }
            }
        });
        extraerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double monto = Double.parseDouble(txtMonto.getText().trim());
                try {
                    cuenta.extraer(monto);
                    txtDescripcion.append("\nExtraccion realizada con exito.");
                    actualizarCuenta();
                } catch (ExtraccionInvalidadException ex) {
                    DatoInvalido dato = ex.getDato();
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al extraer", JOptionPane.ERROR_MESSAGE);
                    txtDescripcion.append("\nError al extraer "+dato.getExtraccion_solicitada()
                            +"\nSe tiene: "+dato.getSaldo());
                }
            }
        });
        depositarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double monto = Double.parseDouble(txtMonto.getText().trim());
                try {
                    cuenta.depositar(monto);
                    txtDescripcion.append("\nDeposito realizado con exito.");
                    actualizarCuenta();
                } catch (DepositoInvalidoException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al extraer", JOptionPane.ERROR_MESSAGE);
                    txtDescripcion.append("\nError al depositar " + monto);
                }
            }
        });
    }

    private void actualizarCuenta() {
        txtCuenta.setText(cuenta.toString());
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }
}
