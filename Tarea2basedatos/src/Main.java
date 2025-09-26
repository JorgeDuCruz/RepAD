public class Main {
    public static void main(String[] args) {

        Anime prueba = new Anime("Naruto", "Anime de ninjas", "2002-10-03", 85);
        ServicioAnime.insertarDatos(prueba,Conexion.conexion());
        ServicioAnime.borrarDatos("Naruto",Conexion.conexion());
    }
}
