package ventana;

import modelo.Acoplado;
import modelo.Camion;
import modelo.Empresa;

import javax.swing.*;
import java.awt.event.*;

public class DialogCrearCamionAcoplado extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JRadioButton camionRadioButton;
    private JRadioButton acopladoRadioButton;
    private JTextField txtMNA;
    private JTextField txtTara;
    private JTextField txtCargaMax;
    private JRadioButton resfrigeradoRadioButton;

    public DialogCrearCamionAcoplado(Empresa empresa) {
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
        camionRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resfrigeradoRadioButton.setVisible(false);
            }
        });
        acopladoRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resfrigeradoRadioButton.setVisible(true);
            }
        });
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = txtMNA.getText().trim();
                double tara = Double.parseDouble(txtTara.getText().trim());
                double cargaMax = Double.parseDouble(txtCargaMax.getText().trim());
                if (acopladoRadioButton.isSelected()) {
                    empresa.agregarAcoplado(new Acoplado(tara, cargaMax, Integer.parseInt(text), resfrigeradoRadioButton.isSelected()));
                } else {
                    try {
                        empresa.agregarCamion(new Camion(text,tara,cargaMax));
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
