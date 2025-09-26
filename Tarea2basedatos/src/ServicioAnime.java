import java.sql.*;

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

    public static void leer(Connection conn) {
        String sql = "select * from anime;";
        try {
            PreparedStatement lectura = conn.prepareStatement(sql);
            ResultSet resultado = lectura.executeQuery();
            while (resultado.next()){
                String nome = resultado.getString(1);
                String desc = resultado.getString(2);
                Date data = resultado.getDate(3);
                int puntuacion = resultado.getInt(4);
                System.out.println("Nombre: "+nome+" Descripcion: "+desc+" Data: "+Anime.dateToString(data)+" Puntuacion: "+puntuacion);
            }
        } catch (SQLException e) {
            System.out.println("Error al leer tabla: "+e.getMessage());
        }
    }

}
