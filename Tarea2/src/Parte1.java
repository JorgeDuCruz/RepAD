import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Parte1 {
    public static void main(String[] args) {
        copiarArchivo("/home/dam/Documentos/AD/RepAD/Tarea2/src/texto1.txt","src/texto2.txt");
        anhadirArchivo("/home/dam/Documentos/AD/RepAD/Tarea2/src/texto1.txt","src/texto2.txt");
    }

    public static void copiarArchivo(String ruta,String rutaE){
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

            leer.close();
            escribir.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void anhadirArchivo(String ruta,String rutaE) {
        try {
            FileInputStream leer = new FileInputStream(new File(ruta));
            FileOutputStream escribir = new FileOutputStream(new File(rutaE),true);
            int lectura, i = 0;
            byte[] b = new byte[leer.available()];

            while (true) {
                lectura = leer.read();
                if (lectura == -1) {
                    break;
                }
                b[i] = (byte) lectura;
                i++;
            }
            escribir.write(b);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}