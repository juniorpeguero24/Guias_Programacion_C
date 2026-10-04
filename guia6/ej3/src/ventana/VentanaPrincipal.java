package ventana;

import excepciones.CargaInvalidaException;
import excepciones.DatoCargaInvalido;
import excepciones.TipoCombustibleInvalidoException;
import paquete.Estacion;
import paquete.Surtidor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame{
    private JPanel panel1;
    private JList<Surtidor> listSurtidor;
    private JButton crearSurtidorButton;
    private JTextField txtCantidad;
    private JButton extraerButton;
    private JRadioButton dieselRadioButton;
    private JRadioButton superRadioButton;
    private JRadioButton premiumRadioButton;
    private JTextArea txtDescripcion;
    private JButton dieselButton;
    private JButton superButton;
    private JButton premiumButton;
    private Estacion estacion;
    private DefaultListModel<Surtidor> modeloListaSurtidores;
    private ButtonGroup btnGroup;

    public VentanaPrincipal() {
        this.estacion = new Estacion();
        this.btnGroup = new ButtonGroup();

        this.modeloListaSurtidores = new DefaultListModel<>();
        this.listSurtidor.setModel(modeloListaSurtidores);
        actualizarLista();

        setContentPane(panel1);
        setTitle("Estacion de Servicio");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

        dieselRadioButton.setActionCommand("Diesel");
        superRadioButton.setActionCommand("Super");
        premiumRadioButton.setActionCommand("Premium");

        btnGroup.add(dieselRadioButton);
        btnGroup.add(superRadioButton);
        btnGroup.add(premiumRadioButton);

        crearSurtidorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                estacion.agregarSurtidor(new Surtidor());
                actualizarLista();
            }
        });
        extraerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double cantidad = Double.parseDouble(txtCantidad.getText().trim());
                Surtidor s = listSurtidor.getSelectedValue();
                ButtonModel seleccion = btnGroup.getSelection();

                if (seleccion != null) {
                    String tipo = seleccion.getActionCommand();
                    try {
                        s.cargarCombustible(tipo, cantidad);
                        txtDescripcion.append("\nCombustible extraido exitosamente del surtidor " + s.getNs());
                        actualizarLista();
                    } catch (TipoCombustibleInvalidoException ex) {
                        txtDescripcion.append("\nError. "+ex.getMessage());
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al cargar", JOptionPane.ERROR_MESSAGE);
                    } catch (CargaInvalidaException ex) {
                        DatoCargaInvalido dato = ex.getDatoCargaInvalido();
                        txtDescripcion.append("\nError. " + dato.getCombustible() + " se tiene: " + dato.getCantidaDisponible() + " se requiere: " + dato.getCantidadRequerida());
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al cargar", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btn = e.getActionCommand();
                Surtidor s = listSurtidor.getSelectedValue();
                switch (btn) {
                    case "Super":
                        s.llenarSuper();
                        break;
                    case "Diesel":
                        s.llenarDiesel();
                        break;
                    case "Premium":
                        s.llenarPremium();
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
                actualizarLista();
            }
        };
        dieselButton.addActionListener(listener);
        superButton.addActionListener(listener);
        premiumButton.addActionListener(listener);
    }

    private void actualizarLista() {
        this.modeloListaSurtidores.clear();
        for (Surtidor s : estacion.getSurtidores()) {
            this.modeloListaSurtidores.addElement(s);
        }
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
