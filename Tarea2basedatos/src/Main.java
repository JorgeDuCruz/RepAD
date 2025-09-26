import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection conn = Conexion.conexion();
        //Anime prueba = new Anime("Naruto", "Anime de ninjas", "2002-10-03", 85);
        //ServicioAnime.insertarDatos(prueba,conn);
        //ServicioAnime.borrarDatos("Naruto",conn);
        ServicioAnime.leer(conn);
    }
}
