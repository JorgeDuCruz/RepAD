import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection conexion(){
        Connection con=null;
        String url = "jdbc:postgresql://10.0.9.185:5432/probas";
        String usuario = "postgres";
        String contrasinal = "admin";
        try {
            con = DriverManager.getConnection(url,usuario,contrasinal);
        } catch (SQLException e) {
            System.out.println("No funciona la conexion");
        }
        return con;
    }
}
