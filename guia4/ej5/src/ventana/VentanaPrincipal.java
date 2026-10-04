package ventana;

import modelo.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame{
    private JPanel panel1;
    private JButton btnChofer;
    private JButton camionAcopladoButton;
    private JButton colectivoButton;
    private JButton acoplarButton;
    private JButton asignarButton;
    private Empresa empresa;
    private DefaultListModel<Chofer> modeloListaChofer;
    private JList<Chofer> listChoferes;
    private JList<Colectivo> listColectivos;
    private JList<Acoplado> listAcoplados;
    private JList<Camion> listCamiones;
    private DefaultListModel<Colectivo> modeloListaColectivo;
    private DefaultListModel<Acoplado> modeloListaAcoplado;
    private DefaultListModel<Camion> modeloListaCamion;

    public VentanaPrincipal(Empresa empresa) {
        setContentPane(panel1);
        setTitle("Empresa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        this.empresa = empresa;
        this.modeloListaChofer = new DefaultListModel<>();
        this.listChoferes.setModel(modeloListaChofer);
        this.modeloListaColectivo = new DefaultListModel<>();
        this.listColectivos.setModel(modeloListaColectivo);
        this.modeloListaAcoplado = new DefaultListModel<>();
        this.listAcoplados.setModel(modeloListaAcoplado);
        this.modeloListaCamion = new DefaultListModel<>();
        this.listCamiones.setModel(modeloListaCamion);

        actualizarListas();
        btnChofer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogCrearChofer dialog = new DialogCrearChofer(empresa);
                dialog.pack();
                dialog.setVisible(true);
                actualizarListaChoferes();
            }
        });
        colectivoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogCrearColectivo dialog = new DialogCrearColectivo(empresa);
                dialog.pack();
                dialog.setVisible(true);
                actualizarListaColectivo();
            }
        });
        camionAcopladoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogCrearCamionAcoplado dialog = new DialogCrearCamionAcoplado(empresa);
                dialog.pack();
                dialog.setVisible(true);
                actualizarListaAcoplados();
            }
        });
        acoplarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Camion camion= listCamiones.getSelectedValue();
                Acoplado acoplado = listAcoplados.getSelectedValue();
                empresa.engancharAcoplado(camion, acoplado);
                actualizarListas();
            }
        });
        asignarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Chofer chofer = listChoferes.getSelectedValue();
                if (!listCamiones.isSelectionEmpty()) {
                    Camion camion = listCamiones.getSelectedValue();
                    empresa.vincularChoferVehiculo(chofer, camion);
                } else if (!listColectivos.isSelectionEmpty()) {
                    Colectivo colectivo = listColectivos.getSelectedValue();
                    empresa.vincularChoferVehiculo(chofer, colectivo);
                }else {
                    JOptionPane.showMessageDialog(VentanaPrincipal.this,
                            "Error, seleccione un vehiculo.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                actualizarListas();
            }
        });
    }

    private void actualizarListaAcoplados() {
        modeloListaAcoplado.clear();
        for (Acoplado a : empresa.getAcoplados()) {
            modeloListaAcoplado.addElement(a);
        }
    }

    private void actualizarListaColectivo() {
        modeloListaColectivo.clear();
        for (Colectivo c : this.empresa.getColectivos()) {
            modeloListaColectivo.addElement(c);
        }
    }

    private void actualizarListas() {
        actualizarListaChoferes();
        actualizarListaColectivo();
        actualizarListaCamion();
        actualizarListaAcoplados();
    }

    private void actualizarListaCamion() {
        modeloListaCamion.clear();
        for (Camion c : empresa.getCamiones()) {
            modeloListaCamion.addElement(c);
        }
    }

    private void actualizarListaChoferes() {
        modeloListaChofer.clear();
        for (Chofer c : this.empresa.getChoferes()) {
            modeloListaChofer.addElement(c);
        }
    }


}
