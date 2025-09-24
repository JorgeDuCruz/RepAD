import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conecction {
    public static Connection conexion() {
        String url = "jdbc:postgresql://10.0.2.15:5432/probas"; // Reemplaza con tu URL
        String usuario = "postgres";                           // Reemplaza con tu usuario
        String contrasinal = "admin";                   // Reemplaza con tu contraseña

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, usuario, contrasinal);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: "+e.getMessage());
        }
        return conn;
    }
}