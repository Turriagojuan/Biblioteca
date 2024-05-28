package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dto.UsuarioDTO;
import conexiones.Mysql_BD;

public class UsuarioDAO {

    public UsuarioDTO validaSesion(UsuarioDTO item) {
        UsuarioDTO usuario = null;
        String SQL_VALIDA_SESION = "SELECT * FROM tb_usuario WHERE correo = ? AND contrasena = ?";
        
        try (Connection con = Mysql_BD.Mysql_BD();
             PreparedStatement ps = con.prepareStatement(SQL_VALIDA_SESION)) {
            
            ps.setString(1, item.getCorreo());
            ps.setString(2, item.getContrasena());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usuario = new UsuarioDTO(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("correo"),
                            rs.getString("contrasena")
                    );
                } else {
                    // Usuario no encontrado
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.INFO, "Usuario no encontrado para correo: {0}", item.getCorreo());
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, "Error al validar sesión", ex);
        }
        return usuario;
    }
   /* public UsuarioDTO validaSesion(UsuarioDTO item) {
        UsuarioDTO usuario = null;
        String SQL_VALIDA_SESION = "SELECT * FROM tb_usuario WHERE correo = ? AND contrasena = ?";
        
        try (Connection con = Mysql_BD.getInstance().cnn;
             PreparedStatement ps = con.prepareStatement(SQL_VALIDA_SESION)) {
            
            ps.setString(1, item.getCorreo());
            ps.setString(2, item.getContrasena());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usuario = new UsuarioDTO(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("correo"),
                            rs.getString("contrasena")
                    );
                } else {
                    // Usuario no encontrado
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.INFO, "Usuario no encontrado para correo: {0}", item.getCorreo());
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, "Error al validar sesión", ex);
        }
        return usuario;
    }*/
}
