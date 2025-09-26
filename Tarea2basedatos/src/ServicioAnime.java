import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class ServicioAnime {
    public static void insertarDatos(Anime anime,Connection conn) {
        try {
            String sql = "INSERT INTO anime (nome, descripcion, data, puntuacion) VALUES (?, ?, ?, ?)";
            PreparedStatement lanzable = conn.prepareStatement(sql);
            lanzable.setString(1, anime.nome);
            lanzable.setString(2, anime.descripcion);
            lanzable.setDate(3, anime.fecha);
            lanzable.setInt(4, anime.puntuacion);
            lanzable.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al insertar datos: " + e.getMessage());
        }

    }

    public static void borrarDatos(String nome, Connection conn) {
        try {
            String sql = "DELETE FROM anime WHERE nome = ?";
            PreparedStatement lanzable = conn.prepareStatement(sql);
            lanzable.setString(1, nome);
            lanzable.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al borrar datos: " + e.getMessage());
        }
    }
}
