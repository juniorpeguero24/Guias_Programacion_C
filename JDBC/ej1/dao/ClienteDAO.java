package dao;

import modelo.Cliente;

import java.sql.*;
import java.util.ArrayList;

public class ClienteDAO {

    public void insertar(Cliente c) throws SQLException {
        String sql = "INSERT INTO cliente (nombre, telefono, direccion, email) VALUES (?, ?, ?, ?)";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getTelefono());
            ps.setString(3, c.getDireccion());
            ps.setString(4, c.getEmail());
            ps.executeUpdate();
            try (ResultSet claves = ps.getGeneratedKeys()) {
                if (claves.next()) {
                    c.setId(claves.getInt(1));          // id asignado por MySQL
                }
            }
        }
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM cliente WHERE id = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public ArrayList<Cliente> listar() throws SQLException {
        return consultar("SELECT * FROM cliente ORDER BY nombre");
    }

    public ArrayList<Cliente> listarConPracticasPorVencer() throws SQLException {
        String sql = "SELECT DISTINCT c.* FROM cliente c "
                + "JOIN mascota m ON m.id_cliente = c.id "
                + "JOIN practica p ON p.id_mascota = m.id "
                + "WHERE p.fecha_vencimiento BETWEEN CURDATE() AND CURDATE() + INTERVAL 7 DAY "
                + "ORDER BY c.nombre";
        return consultar(sql);
    }

    private ArrayList<Cliente> consultar(String sql) throws SQLException {
        ArrayList<Cliente> clientes = new ArrayList<>();
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                clientes.add(new Cliente(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getString("direccion"),
                        rs.getString("email")));
            }
        }
        return clientes;
    }
}