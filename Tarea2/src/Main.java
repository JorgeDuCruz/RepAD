import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) {
        crearArchivo("/home/dam/Documentos/AD/RepAD/Tarea2/src/texto1.txt","src/texto2.txt");
    }

    public static void crearArchivo(String ruta,String rutaE){
        try {
            FileInputStream leer = new FileInputStream(new File(ruta));
            FileOutputStream escribir = new FileOutputStream(new File(rutaE));
            int lectura,i=0;
            byte[] b = new byte[leer.available()];

            while (true){
                lectura = leer.read();
                if (lectura==-1) {
                    break;
                }
                b[i] = (byte) lectura;
                i++;
            }
            escribir.write(b);


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}