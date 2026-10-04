package ventana;

import paquete.Personaje;
import paquete.PersonajeFactory;
import paquete.Posicion;
import paquete.Universo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {
    private JPanel panel1;
    private JPanel panelPersonajes;
    private JList<Personaje> listPersonajes;
    private JList<Personaje> listPersonajes2;
    private JButton btnAtacar;
    private JTextField txtNombre;
    private JButton btnArquero;
    private JButton guerreroButton;
    private JButton caballeroButton;
    private JTextField txtX;
    private JTextField txtY;
    private JButton moverButton;
    private JTextArea txtDescripcion;
    private JButton limpiarButton;
    private DefaultListModel<Personaje> modeloVistaPersonajes;
    private Universo universo;

    public VentanaPrincipal(Universo universo) {
        this.universo = universo;

        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setName("Juego de Estrategia");
        pack();
        setLocationRelativeTo(null);

        this.modeloVistaPersonajes = new DefaultListModel<>();
        listPersonajes.setModel(modeloVistaPersonajes);
        listPersonajes2.setModel(modeloVistaPersonajes);

        actualizarListas();
        btnArquero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearPersonaje(universo, "Arquero");
            }
        });
        guerreroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearPersonaje(universo, "Guerrero");
            }
        });
        caballeroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearPersonaje(universo, "Guerrero");
            }
        });
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listPersonajes.clearSelection();
                listPersonajes2.clearSelection();
            }
        });
        moverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Personaje p1 = listPersonajes.getSelectedValue();
                Personaje p2 = listPersonajes2.getSelectedValue();
                double x = Double.parseDouble(txtX.getText().trim());
                double y = Double.parseDouble(txtY.getText().trim());
                if ((p1 != null && p2 != null)) {
                    JOptionPane.showMessageDialog(null,"Por favor seleccione un solo personaje." +
                            "\nLimpie las selecciones.","Error al mover",JOptionPane.ERROR_MESSAGE);
                } else if (p1 != null) {
                    p1.getPosicion().incrementaPos(x,y);
                    txtDescripcion.append("\n" + p1.getNombre() + " se movio con exito a X: "
                            + x + " Y: " + y);
                }else {
                    p2.getPosicion().incrementaPos(x, y);
                    txtDescripcion.append("\n" + p2.getNombre() + " se movio con exito a X: "
                            + x + " Y: " + y);
                }
                actualizarListas();
            }
        });
        btnAtacar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Personaje p1 = listPersonajes.getSelectedValue();
                Personaje p2 = listPersonajes2.getSelectedValue();
                if (((p1 != null) && (p2 != null)) || !p1.equals(p2)) {
                    if (p1.ataca(p2)) {
                        txtDescripcion.append("\n" + p1.getNombre() + " ataco con exito a " + p2.getNombre());
                        actualizarListas();
                    } else
                        txtDescripcion.append("\n" + p1.getNombre() + " no pudo atacar a " + p2.getNombre());
                } else {
                    JOptionPane.showMessageDialog(null, "\nSeleccione a un personaje distinto de cada lista.", "Error al atacar", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void crearPersonaje(Universo universo, String tipo) {
        String nombre = txtNombre.getText().trim();
        double x = Double.parseDouble(txtX.getText().trim());
        double y = Double.parseDouble(txtY.getText().trim());
        if ((x != 0) && (y != 0)) {
            universo.agregarPersonaje(PersonajeFactory.crearPersonaje(tipo, nombre, new Posicion(x, y)));
        } else
            universo.agregarPersonaje(PersonajeFactory.crearPersonaje(tipo, nombre, new Posicion(0, 0)));
        actualizarListas();
    }

    private void actualizarListas() {
        this.modeloVistaPersonajes.clear();
        for (Personaje p : this.universo.getPersonajes()) {
            this.modeloVistaPersonajes.addElement(p);
        }
    }
}
