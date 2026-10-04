package ventana;

import modelo.ColectivoLarga;
import modelo.ColectivoLinea;
import modelo.Empresa;

import javax.swing.*;
import java.awt.event.*;

public class DialogCrearColectivo extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtModelo;
    private JTextField txtCantP;
    private JRadioButton rdbtnCLD;
    private JRadioButton rdbtnCLinea;
    private JRadioButton rdbtnCocheCama;

    public DialogCrearColectivo(Empresa empresa) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        rdbtnCLD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rdbtnCocheCama.setVisible(true);
            }
        });
        rdbtnCLinea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rdbtnCocheCama.setVisible(false);
            }
        });
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String colectivo;
                String modelo = txtModelo.getText().trim();
                int cantP = Integer.parseInt(txtCantP.getText().trim());
                if (rdbtnCLD.isSelected()) {
                    try {
                        empresa.agregarColectivo(new ColectivoLarga(modelo, cantP, rdbtnCocheCama.isSelected()));
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                } else {
                    try {
                        empresa.agregarColectivo(new ColectivoLinea(modelo, cantP));
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
                dispose();
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

}
