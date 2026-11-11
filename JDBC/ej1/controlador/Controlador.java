package controlador;

import modelo.Cliente;
import modelo.Mascota;
import modelo.Practica;
import modelo.Veterinaria;
import vista.VistaPrincipal;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Controlador implements ActionListener, ListSelectionListener {
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final Veterinaria modelo;
    private final VistaPrincipal vista;

    public Controlador(Veterinaria modelo, VistaPrincipal vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    /** Carga inicial: se llama desde el Main después de mostrar la ventana. */
    public void iniciar() {
        try {
            cargarClientes();
        } catch (SQLException e) {
            vista.error("No se pudo conectar a la base de datos.\n¿Está MySQL encendido en XAMPP?\n\n" + e.getMessage());
        }
    }

    // ======================= BOTONES =======================

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            switch (e.getActionCommand()) {
                case VistaPrincipal.ALTA_CLIENTE -> altaCliente();
                case VistaPrincipal.BAJA_CLIENTE -> bajaCliente();
                case VistaPrincipal.CONSULTA_CLIENTE -> consultaCliente();
                case VistaPrincipal.ALTA_MASCOTA -> altaMascota();
                case VistaPrincipal.BAJA_MASCOTA -> bajaMascota();
                case VistaPrincipal.CONSULTA_MASCOTA -> consultaMascota();
                case VistaPrincipal.ALTA_PRACTICA -> altaPractica();
                case VistaPrincipal.BAJA_PRACTICA -> bajaPractica();
                case VistaPrincipal.CONSULTA_PRACTICA -> consultaPractica();
                case VistaPrincipal.NOTIFICAR -> clientesANotificar();
            }
        } catch (SQLException ex) {
            vista.error("Error de base de datos:\n" + ex.getMessage());
        }
    }

    // ======================= SELECCIÓN EN LAS LISTAS =======================

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting()) return;            // evita procesar el mismo clic dos veces
        try {
            if (vista.esListaClientes(e.getSource())) {
                cargarMascotas();
            } else if (vista.esListaMascotas(e.getSource())) {
                cargarPracticas();
            }
        } catch (SQLException ex) {
            vista.error("Error de base de datos:\n" + ex.getMessage());
        }
    }

    // ======================= CLIENTES =======================

    private void altaCliente() throws SQLException {
        Cliente c = vista.pedirCliente();
        if (c == null) return;                           // canceló
        modelo.agregarCliente(c);
        cargarClientes();
    }

    private void bajaCliente() throws SQLException {
        Cliente c = vista.getClienteSeleccionado();
        if (c == null) { vista.aviso("Seleccioná un cliente."); return; }
        if (vista.confirmar("¿Eliminar a " + c.getNombre() + "?\nTambién se borran sus mascotas y prácticas.")) {
            modelo.eliminarCliente(c);
            cargarClientes();
        }
    }

    private void consultaCliente() throws SQLException {
        Cliente c = vista.getClienteSeleccionado();
        if (c == null) {                                  // sin selección: solo refresca la lista
            cargarClientes();
            return;
        }
        StringBuilder sb = new StringBuilder()
                .append("Nombre: ").append(c.getNombre())
                .append("\nTeléfono: ").append(c.getTelefono())
                .append("\nDirección: ").append(c.getDireccion())
                .append("\nEmail: ").append(c.getEmail())
                .append("\n\nMascotas:");
        ArrayList<Mascota> mascotas = modelo.getMascotas(c);
        if (mascotas.isEmpty()) sb.append(" ninguna");
        for (Mascota m : mascotas) sb.append("\n  - ").append(m);
        vista.mostrarDetalle("Cliente", sb.toString());
    }

    // ======================= MASCOTAS =======================

    private void altaMascota() throws SQLException {
        Cliente dueño = vista.getClienteSeleccionado();
        if (dueño == null) { vista.aviso("Primero seleccioná el cliente dueño de la mascota."); return; }
        Mascota m = vista.pedirMascota(dueño);
        if (m == null) return;
        modelo.agregarMascota(dueño, m);
        cargarMascotas();
    }

    private void bajaMascota() throws SQLException {
        Mascota m = vista.getMascotaSeleccionada();
        if (m == null) { vista.aviso("Seleccioná una mascota."); return; }
        if (vista.confirmar("¿Eliminar a " + m.getNombre() + "?\nTambién se borran sus prácticas.")) {
            modelo.eliminarMascota(m);
            cargarMascotas();
        }
    }

    private void consultaMascota() throws SQLException {
        Mascota m = vista.getMascotaSeleccionada();
        if (m == null) { vista.aviso("Seleccioná una mascota."); return; }
        String nac = m.getNacimiento() != null ? m.getNacimiento().format(FORMATO) : "sin dato";
        StringBuilder sb = new StringBuilder()
                .append("Nombre: ").append(m.getNombre())
                .append("\nAnimal: ").append(m.getAnimal())
                .append("\nNacimiento: ").append(nac)
                .append("\n\nHistoria clínica:\n").append(m.getHistoriaClinica())
                .append("\n\nPrácticas:");
        ArrayList<Practica> practicas = modelo.getPracticas(m);
        if (practicas.isEmpty()) sb.append(" ninguna");
        for (Practica p : practicas) sb.append("\n  - ").append(p);
        vista.mostrarDetalle("Mascota", sb.toString());
    }

    // ======================= PRÁCTICAS =======================

    private void altaPractica() throws SQLException {
        Mascota m = vista.getMascotaSeleccionada();
        if (m == null) { vista.aviso("Primero seleccioná la mascota."); return; }
        Practica p = vista.pedirPractica(m);
        if (p == null) return;
        modelo.agregarPractica(m, p);
        cargarPracticas();
    }

    private void bajaPractica() throws SQLException {
        Practica p = vista.getPracticaSeleccionada();
        if (p == null) { vista.aviso("Seleccioná una práctica."); return; }
        if (vista.confirmar("¿Eliminar la práctica \"" + p.getDescripcion() + "\"?")) {
            modelo.eliminarPractica(p);
            cargarPracticas();
        }
    }

    private void consultaPractica() {
        Practica p = vista.getPracticaSeleccionada();
        if (p == null) { vista.aviso("Seleccioná una práctica."); return; }
        String venc = p.getFechaVencimiento() != null ? p.getFechaVencimiento().format(FORMATO) : "no vence";
        vista.mostrarDetalle("Práctica",
                "Descripción: " + p.getDescripcion()
                        + "\nFecha: " + p.getFecha().format(FORMATO)
                        + "\nVencimiento: " + venc
                        + "\n\nComentarios:\n" + p.getComentarios());
    }

    // ======================= NOTIFICACIÓN =======================

    private void clientesANotificar() throws SQLException {
        ArrayList<Cliente> clientes = modelo.getClientesANotificar();
        if (clientes.isEmpty()) {
            vista.aviso("No hay clientes con prácticas que venzan en los próximos 7 días.");
            return;
        }
        StringBuilder sb = new StringBuilder("Clientes con prácticas que vencen en los próximos 7 días:\n");
        for (Cliente c : clientes) {
            sb.append("\n").append(c.getNombre()).append(" <").append(c.getEmail()).append(">");
        }
        vista.mostrarDetalle("Clientes a notificar", sb.toString());
    }

    // ======================= REFRESCOS =======================

    private void cargarClientes() throws SQLException {
        vista.mostrarClientes(modelo.getClientes());
        vista.mostrarMascotas(new ArrayList<>());        // nada seleccionado todavía
        vista.mostrarPracticas(new ArrayList<>());
    }

    private void cargarMascotas() throws SQLException {
        Cliente c = vista.getClienteSeleccionado();
        vista.mostrarMascotas(c != null ? modelo.getMascotas(c) : new ArrayList<>());
        vista.mostrarPracticas(new ArrayList<>());
    }

    private void cargarPracticas() throws SQLException {
        Mascota m = vista.getMascotaSeleccionada();
        vista.mostrarPracticas(m != null ? modelo.getPracticas(m) : new ArrayList<>());
    }
}