import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection conexion(){
        String url = "jdbc:postgresql://10.0.9.185:5432/probas";
        String user = "postgres";
        String contra = "admin";

        try {
            Connection conn = DriverManager.getConnection(url,user,contra);
        } catch (SQLException e) {
            System.out.println("Error de conexion");
        }
    }
}
