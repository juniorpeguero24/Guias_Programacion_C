package vista;

import controlador.Controlador;
import modelo.Cliente;
import modelo.Mascota;
import modelo.Practica;

import javax.swing.*;
import java.util.List;

public class VistaPrincipal extends JFrame {
    // ---- comandos que recibe el controlador ----
    public static final String ALTA_CLIENTE = "ALTA_CLIENTE";
    public static final String BAJA_CLIENTE = "BAJA_CLIENTE";
    public static final String CONSULTA_CLIENTE = "CONSULTA_CLIENTE";
    public static final String ALTA_MASCOTA = "ALTA_MASCOTA";
    public static final String BAJA_MASCOTA = "BAJA_MASCOTA";
    public static final String CONSULTA_MASCOTA = "CONSULTA_MASCOTA";
    public static final String ALTA_PRACTICA = "ALTA_PRACTICA";
    public static final String BAJA_PRACTICA = "BAJA_PRACTICA";
    public static final String CONSULTA_PRACTICA = "CONSULTA_PRACTICA";
    public static final String NOTIFICAR = "NOTIFICAR";

    // ---- componentes del .form (los nombres tienen que coincidir con el field name) ----
    private JPanel panel1;
    private JButton altaClienteButton;
    private JButton bajaClienteButton;
    private JButton consultaClienteButton;
    private JList<Cliente> listClientes;
    private JList<Mascota> listMascotas;
    private JList<Practica> listPracticas;
    private JButton btnAltaMascota;
    private JButton btnBajaMascota;
    private JButton btnConsultaMascota;
    private JButton btnAltaPractica;
    private JButton btnBajaPractica;
    private JButton btnConsultaPractica;
    private JButton btnNotificar;

    private final DefaultListModel<Cliente> modeloClientes = new DefaultListModel<>();
    private final DefaultListModel<Mascota> modeloMascotas = new DefaultListModel<>();
    private final DefaultListModel<Practica> modeloPracticas = new DefaultListModel<>();

    public VistaPrincipal() {
        super("Veterinaria");
        listClientes.setModel(modeloClientes);
        listMascotas.setModel(modeloMascotas);
        listPracticas.setModel(modeloPracticas);
        listClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listMascotas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listPracticas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void arranca() {
        setContentPane(panel1);
        pack();
        setSize(Math.max(getWidth(), 900), Math.max(getHeight(), 450));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void setControlador(Controlador c) {
        registrar(altaClienteButton, ALTA_CLIENTE, c);
        registrar(bajaClienteButton, BAJA_CLIENTE, c);
        registrar(consultaClienteButton, CONSULTA_CLIENTE, c);
        registrar(btnAltaMascota, ALTA_MASCOTA, c);
        registrar(btnBajaMascota, BAJA_MASCOTA, c);
        registrar(btnConsultaMascota, CONSULTA_MASCOTA, c);
        registrar(btnAltaPractica, ALTA_PRACTICA, c);
        registrar(btnBajaPractica, BAJA_PRACTICA, c);
        registrar(btnConsultaPractica, CONSULTA_PRACTICA, c);
        registrar(btnNotificar, NOTIFICAR, c);
        // al seleccionar un cliente se cargan sus mascotas; al seleccionar una mascota, sus prácticas
        listClientes.addListSelectionListener(c);
        listMascotas.addListSelectionListener(c);
    }

    private void registrar(JButton boton, String comando, Controlador c) {
        boton.setActionCommand(comando);   // el comando no depende del texto del botón
        boton.addActionListener(c);
    }

    // ---------------- listas ----------------

    public void mostrarClientes(List<Cliente> clientes) { cargar(modeloClientes, clientes); }
    public void mostrarMascotas(List<Mascota> mascotas) { cargar(modeloMascotas, mascotas); }
    public void mostrarPracticas(List<Practica> practicas) { cargar(modeloPracticas, practicas); }

    private <T> void cargar(DefaultListModel<T> modelo, List<T> datos) {
        modelo.clear();
        for (T d : datos) modelo.addElement(d);
    }

    public Cliente getClienteSeleccionado() { return listClientes.getSelectedValue(); }
    public Mascota getMascotaSeleccionada() { return listMascotas.getSelectedValue(); }
    public Practica getPracticaSeleccionada() { return listPracticas.getSelectedValue(); }

    /** Para que el controlador sepa qué lista disparó el evento de selección. */
    public boolean esListaClientes(Object fuente) { return fuente == listClientes; }
    public boolean esListaMascotas(Object fuente) { return fuente == listMascotas; }

    // ---------------- diálogos de alta (devuelven null si se canceló) ----------------

    public Cliente pedirCliente() {
        DialogoCliente d = new DialogoCliente(this);
        return d.mostrar() ? d.getCliente() : null;
    }

    public Mascota pedirMascota(Cliente dueño) {
        DialogoMascota d = new DialogoMascota(this, dueño.getNombre());
        return d.mostrar() ? d.getMascota() : null;
    }

    public Practica pedirPractica(Mascota mascota) {
        DialogoPractica d = new DialogoPractica(this, mascota.getNombre());
        return d.mostrar() ? d.getPractica() : null;
    }

    // ---------------- mensajes ----------------

    public void aviso(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }

    public void error(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public boolean confirmar(String msg) {
        return JOptionPane.showConfirmDialog(this, msg, "Confirmar", JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION;
    }

    /** Muestra un texto largo (detalle de una consulta) en un área de solo lectura. */
    public void mostrarDetalle(String titulo, String texto) {
        JTextArea area = new JTextArea(texto, 12, 40);
        area.setEditable(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        JOptionPane.showMessageDialog(this, new JScrollPane(area), titulo, JOptionPane.PLAIN_MESSAGE);
    }
}