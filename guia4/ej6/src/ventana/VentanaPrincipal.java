package ventana;

import excepciones.MontoInvalidoException;
import paquete.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class VentanaPrincipal extends JFrame{
    private JPanel panel1;
    private JTextField txtTitular;
    private JComboBox<String> cmbCuenta;
    private JTextField txtTopeDesc;
    private JButton btnCrear;
    private JButton btnExtraer;
    private JButton btnDepositar;
    private JList<CuentaBancaria> listCuentas;
    private JPanel panelTopeDesc;
    private JTextField txtMonto;
    private JTextArea txtAreaDescripcion;
    private DefaultListModel<CuentaBancaria> modeloListaCuentas;
    private Banco banco;

    public VentanaPrincipal(Banco banco) {
        this.banco = banco;

        setContentPane(panel1);
        setTitle("Sistema Bancario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

        this.cmbCuenta.addItem("Caja de ahorro");
        this.cmbCuenta.addItem("Cuenta corriente");
        this.cmbCuenta.addItem("Cuenta universitaria");

        this.modeloListaCuentas = new DefaultListModel<>();
        this.listCuentas.setModel(modeloListaCuentas);

        this.panelTopeDesc.setVisible(false);

        actualizarLista();
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titular = txtTitular.getText().trim();
                String cuenta = Objects.requireNonNull(cmbCuenta.getSelectedItem()).toString();

                switch (cuenta.toLowerCase()) {
                    case "caja de ahorro":
                        try {
                            banco.agregarCuenta(new CajaDeAhorro(titular));
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                    case "cuenta corriente":
                        double topeDesc = Double.parseDouble(txtTopeDesc.getText().trim());
                        if (topeDesc != 0) {
                            try {
                                banco.agregarCuenta(new CuentaCorriente(titular,topeDesc));
                            } catch (Exception ex) {
                                throw new RuntimeException(ex);
                            }
                        }else {
                            try {
                                banco.agregarCuenta(new CuentaCorriente(titular));
                            } catch (Exception ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                        break;
                    case "cuenta universitaria":
                        try {
                            banco.agregarCuenta(new CuentaUniversitaria(titular));
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                    default:
                        throw new IllegalArgumentException("\n ERROR tipo de cuenta");

                }
                actualizarLista();
            }
        });
        cmbCuenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cuenta = Objects.requireNonNull(cmbCuenta.getSelectedItem()).toString();
                panelTopeDesc.setVisible("cuenta corriente".equalsIgnoreCase(cuenta));
            }
        });
        btnExtraer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double monto = Double.parseDouble(txtMonto.getText().trim());
                CuentaBancaria cuenta= listCuentas.getSelectedValue();

                if (cuenta != null) {
                    try {
                        cuenta.extraer(monto);
                    } catch (MontoInvalidoException ex) {
                        txtAreaDescripcion.append(ex.getMensaje());
                        JOptionPane.showMessageDialog(null,ex.getMessage(),"Error al extraer",JOptionPane.ERROR_MESSAGE);
                    }
                    actualizarLista();
                }else
                    JOptionPane.showMessageDialog(null, "Seleccione una cuenta de la lista.", "Error",JOptionPane.WARNING_MESSAGE);
            }
        });
        btnDepositar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double monto = Double.parseDouble(txtMonto.getText().trim());
                CuentaBancaria cuenta= listCuentas.getSelectedValue();

                if (cuenta != null) {
                    try {
                        cuenta.depositar(monto);
                    } catch (MontoInvalidoException ex) {
                        txtAreaDescripcion.append("\n"+ex.getMensaje());
                        JOptionPane.showMessageDialog(null,ex.getMessage(),"Error al depositar",JOptionPane.ERROR_MESSAGE);
                    }
                    actualizarLista();
                }else
                    JOptionPane.showMessageDialog(null, "Seleccione una cuenta de la lista.", "Error",JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    private void actualizarLista() {
        this.modeloListaCuentas.clear();
        for (CuentaBancaria c : banco.getCuentas()) {
            this.modeloListaCuentas.addElement(c);
        }
    }
}
