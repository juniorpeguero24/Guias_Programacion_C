package modelo;

import dao.ClienteDAO;
import dao.MascotaDAO;
import dao.PracticaDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class Veterinaria {
    private final ClienteDAO clienteDAO = new ClienteDAO();
    private final MascotaDAO mascotaDAO = new MascotaDAO();
    private final PracticaDAO practicaDAO = new PracticaDAO();

    // Clientes
    public void agregarCliente(Cliente c) throws SQLException { clienteDAO.insertar(c); }
    public void eliminarCliente(Cliente c) throws SQLException { clienteDAO.eliminar(c.getId()); }
    public ArrayList<Cliente> getClientes() throws SQLException { return clienteDAO.listar(); }
    public ArrayList<Cliente> getClientesANotificar() throws SQLException {
        return clienteDAO.listarConPracticasPorVencer();
    }

    // Mascotas
    public void agregarMascota(Cliente dueño, Mascota m) throws SQLException { mascotaDAO.insertar(m, dueño.getId()); }
    public void eliminarMascota(Mascota m) throws SQLException { mascotaDAO.eliminar(m.getId()); }
    public ArrayList<Mascota> getMascotas(Cliente dueño) throws SQLException {
        return mascotaDAO.listarPorCliente(dueño.getId());
    }

    // Prácticas
    public void agregarPractica(Mascota m, Practica p) throws SQLException { practicaDAO.insertar(p, m.getId()); }
    public void eliminarPractica(Practica p) throws SQLException { practicaDAO.eliminar(p.getId()); }
    public ArrayList<Practica> getPracticas(Mascota m) throws SQLException {
        return practicaDAO.listarPorMascota(m.getId());
    }
}