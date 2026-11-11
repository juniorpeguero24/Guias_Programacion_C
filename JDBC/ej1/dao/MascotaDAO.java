package dao;

import modelo.Mascota;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class MascotaDAO {

    public void insertar(Mascota m, int idCliente) throws SQLException {
        String sql = "INSERT INTO mascota (nombre, animal, fecha_nacimiento, historia_clinica, id_cliente) "
                + "VALUES (?, ?, ?, ?, ?)";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, m.getNombre());
            ps.setString(2, m.getAnimal());
            if (m.getNacimiento() != null) {
                ps.setDate(3, Date.valueOf(m.getNacimiento()));   // LocalDate -> java.sql.Date
            } else {
                ps.setNull(3, Types.DATE);
            }
            ps.setString(4, m.getHistoriaClinica());
            ps.setInt(5, idCliente);
            ps.executeUpdate();
            try (ResultSet claves = ps.getGeneratedKeys()) {
                if (claves.next()) {
                    m.setId(claves.getInt(1));
                }
            }
        }
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM mascota WHERE id = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public ArrayList<Mascota> listarPorCliente(int idCliente) throws SQLException {
        ArrayList<Mascota> mascotas = new ArrayList<>();
        String sql = "SELECT * FROM mascota WHERE id_cliente = ? ORDER BY nombre";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idCliente);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Date nac = rs.getDate("fecha_nacimiento");
                    LocalDate nacimiento = (nac != null) ? nac.toLocalDate() : null;
                    mascotas.add(new Mascota(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("animal"),
                            nacimiento,
                            rs.getString("historia_clinica")));
                }
            }
        }
        return mascotas;
    }
}