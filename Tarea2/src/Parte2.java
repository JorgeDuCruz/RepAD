import java.io.*;

public class Parte2 {
    public static void main(String[] args) {
        String rutaFoto1 = "TobyFox.jpg",rutaFoto2 = "foto2.jpg",rutaFoto2B = "fotoBuffered.jpg";

        Parte1.copiarArchivo(rutaFoto1,rutaFoto2);
        //Apartado 1: Si ocupan lo mismo

        Parte1.anhadirArchivo(rutaFoto1,rutaFoto2);
        //Apartado 2: No se ve duplicada la imagen pero si se percibe que ocupa el doble

        //Apartado 3:
        copiarBuffered(rutaFoto1,rutaFoto2B);

        //Apartado 4: No noto diferencias de copiado porque el copidado ya era muy rapido sin los buffered
    }


    public static void copiarBuffered(String rutaO, String rutaD){
        try {
            BufferedInputStream leer = new BufferedInputStream(new FileInputStream(rutaO));
            byte [] b = leer.readAllBytes();
            BufferedOutputStream escribir = new BufferedOutputStream(new FileOutputStream(rutaD));
            escribir.write(b);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
