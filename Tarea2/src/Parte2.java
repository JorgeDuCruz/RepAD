import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;

public class Parte2 {
    public static void main(String[] args) {
        Parte1.copiarArchivo("TobyFox.jpg","foto2.jpg");
        //Apartado 1: Si ocupan lo mismo

        Parte1.anhadirArchivo("TobyFox.jpg","foto2.jpg");
        //Apartado 2 : No se ve duplicada la imagen pero si se percibe que ocupa el doble
    }


    public static void copiarBuffered(String rutaO, String rutaD){
        try {
            BufferedInputStream leer = new BufferedInputStream(new FileInputStream(rutaO));
            byte [] b = leer.readAllBytes();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
