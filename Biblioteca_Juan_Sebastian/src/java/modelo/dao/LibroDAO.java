package modelo.dao;

import java.util.List;
import modelo.dto.LibroDTO;
import conexiones.Mysql_BD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LibroDAO implements Contrato<LibroDTO> {
    private static final String SQL_READALL = "SELECT * FROM tb_libro ";
    private static final String SQL_CREATE = "INSERT INTO tb_libro(isbn, nombre, autor, editorial, anio) VALUES (?,?,?,?,?) ";
    private static final String SQL_DELETE = "DELETE FROM tb_libro WHERE isbn =? ";
    private static final String SQL_UPDATE = "UPDATE tb_libro SET nombre =?, autor =?, editorial =?, anio =? WHERE isbn =? ";
    private static final String SQL_READ = "SELECT * FROM tb_libro WHERE isbn =? ";

    @Override
    public boolean create(LibroDTO nuevo) {
        int rowsAffected = 0;
        try (Connection con = Mysql_BD.Mysql_BD();
             PreparedStatement ps = con.prepareStatement(SQL_CREATE)) {

            ps.setLong(1, nuevo.getIsbn());
            ps.setString(2, nuevo.getNombre());
            ps.setString(3, nuevo.getAutor());
            ps.setString(4, nuevo.getEditorial());
            ps.setInt(5, nuevo.getAnio());

            rowsAffected = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowsAffected > 0;
    }

    @Override
    public boolean delete(Object item) {
        int rowsAffected = 0;
        if (item instanceof Long) {
            try (Connection con = Mysql_BD.Mysql_BD();
                 PreparedStatement ps = con.prepareStatement(SQL_DELETE)) {

                ps.setLong(1, (Long) item);

                rowsAffected = ps.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rowsAffected > 0;
    }

    @Override
    public boolean update(LibroDTO filter) {
        int rowsAffected = 0;
        try (Connection con = Mysql_BD.Mysql_BD();
             PreparedStatement ps = con.prepareStatement(SQL_UPDATE)) {

            ps.setString(1, filter.getNombre());
            ps.setString(2, filter.getAutor());
            ps.setString(3, filter.getEditorial());
            ps.setInt(4, filter.getAnio());
            ps.setLong(5, filter.getIsbn());

            rowsAffected = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowsAffected > 0;
    }

    @Override
    public LibroDTO read(LibroDTO filter) {
        LibroDTO libro = null;
        try (Connection con = Mysql_BD.Mysql_BD();
             PreparedStatement ps = con.prepareStatement(SQL_READ)) {

            ps.setLong(1, filter.getIsbn());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    libro = new LibroDTO(
                            rs.getLong("isbn"),
                            rs.getString("nombre"),
                            rs.getString("autor"),
                            rs.getString("editorial"),
                            rs.getInt("anio")
                    );
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return libro;
    }

    @Override
    public List<LibroDTO> readAll() {
        List<LibroDTO> libros = new ArrayList<>();
        String query = "SELECT * FROM tb_libro";

        try (Connection cnn = Mysql_BD.Mysql_BD();
             PreparedStatement pstmt = cnn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                LibroDTO libro = new LibroDTO();
                libro.setIsbn(rs.getInt("isbn"));
                libro.setNombre(rs.getString("nombre"));
                libro.setAutor(rs.getString("autor"));
                libro.setEditorial(rs.getString("editorial"));
                libro.setAnio(rs.getInt("anio"));
                libros.add(libro);
            }

        } catch (SQLException ex) {
            System.out.println("Error al leer los datos de la base de datos: " + ex.getMessage());
        }

        return libros;
    }
}