/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexiones;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mysql_BD {
    private static final String URL = "jdbc:mysql://localhost:3307/biblioteca";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection Mysql_BD() throws SQLException {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            // Aquí puedes registrar o lanzar la excepción para manejarla en otro lugar
            throw new SQLException("Error al conectar a la base de datos", e);
        } finally {
            // Asegúrate de cerrar la conexión en caso de que se haya abierto
            if (conexion != null) {
                System.out.println("Conexión exitosa");
            }
        }
        return conexion;
    }
}

    
   
   

   
    

