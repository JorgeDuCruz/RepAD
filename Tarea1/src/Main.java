import java.io.File;
import java.io.IOException;

public class Main{
    public static void main(String[] args) {
        System.out.println(eDirectorio("/home/dam/Documentos/AcesoDatos"));
        System.out.println(eFicheiro("/home/dam/Documentos/AcesoDatos"));
        creaDirectorio("/home/dam/Documentos/AcesoDatos/Tarea1/pruebaDirectorio");
        creaFicheiro("/home/dam/Documentos/AcesoDatos/Tarea1/pruebaDirectorio","Prueba");
    }//en static


    public static boolean eDirectorio(String cadea){
        File archivo = new File(cadea);
        return archivo.isDirectory();
    }
    public static boolean eFicheiro(String cadea){
        File archivo = new File(cadea);
        return archivo.isFile();

    }
    public static void creaDirectorio(String cadea){
        File archivo = new File(cadea);
        boolean creado = archivo.mkdir();
        if(creado){
            System.out.println("Archivo creado");
        }else{
            System.out.println("No se ha creado");
        }
    }


    public static void creaFicheiro(String dirName, String fileName){
        File archivo = new File(dirName,fileName);
        boolean resultado;
        try{
            resultado=archivo.createNewFile();
            if (resultado) {
                System.out.println("Archivo creado");
            }else {
                System.out.println("Archivo no creado");
            }
        }catch (IOException e){
            System.out.println(e.getMessage());

        }


    }
}//end class