package ventana;

import modelo.Categoria;
import modelo.Chofer;
import modelo.Empresa;

import javax.swing.*;
import java.awt.event.*;

public class DialogCrearChofer extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtNombre;
    private JComboBox<Categoria> cmbCategoria;

    public DialogCrearChofer(Empresa empresa) {

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        this.cmbCategoria.removeAllItems();

        for (Categoria c: empresa.getCategorias()){
            this.cmbCategoria.addItem(c);
        }

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
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText().trim();
                Categoria categoria = (Categoria) cmbCategoria.getSelectedItem();
                if (nombre.isEmpty()) {
                    JOptionPane.showMessageDialog(DialogCrearChofer.this, "El nombre no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (categoria == null) {
                    JOptionPane.showMessageDialog(DialogCrearChofer.this, "Debe seleccionar una categoría.", "Validación", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                empresa.agregarChofer(new Chofer(nombre,categoria));
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
