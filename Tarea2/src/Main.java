import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) {
        crearArchivo("/home/dam/Documentos/AD/RepAD/Tarea2/src/texto1.txt");
    }

    public static void crearArchivo(String ruta){
        try {
            FileInputStream leer = new FileInputStream(new File(ruta));
            int lectura;
            char letra;

            while (true) {
                lectura = leer.read();
                if (lectura==-1){
                    break;
                }

                letra = (char) lectura;
                System.out.print(letra);
            }



        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}