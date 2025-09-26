import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection conexion() {
        String url = "jdbc:postgresql://10.0.9.140:5432/probas";
        String usuario = "postgres";
        String contrasinal = "admin";

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