package dao;

import modelo.Practica;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class PracticaDAO {

    public void insertar(Practica p, int idMascota) throws SQLException {
        String sql = "INSERT INTO practica (descripcion, fecha, fecha_vencimiento, comentarios, id_mascota) "
                + "VALUES (?, ?, ?, ?, ?)";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, p.getDescripcion());
            ps.setDate(2, Date.valueOf(p.getFecha()));
            if (p.getFechaVencimiento() != null) {
                ps.setDate(3, Date.valueOf(p.getFechaVencimiento()));
            } else {
                ps.setNull(3, Types.DATE);                          // vencimiento opcional
            }
            ps.setString(4, p.getComentarios());
            ps.setInt(5, idMascota);
            ps.executeUpdate();
            try (ResultSet claves = ps.getGeneratedKeys()) {
                if (claves.next()) {
                    p.setId(claves.getInt(1));
                }
            }
        }
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM practica WHERE id = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public ArrayList<Practica> listarPorMascota(int idMascota) throws SQLException {
        ArrayList<Practica> practicas = new ArrayList<>();
        String sql = "SELECT * FROM practica WHERE id_mascota = ? ORDER BY fecha DESC";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idMascota);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Date venc = rs.getDate("fecha_vencimiento");      // null si no tiene
                    practicas.add(new Practica(
                            rs.getInt("id"),
                            rs.getString("descripcion"),
                            rs.getString("comentarios"),
                            rs.getDate("fecha").toLocalDate(),
                            venc != null ? venc.toLocalDate() : null));
                }
            }
        }
        return practicas;
    }
}