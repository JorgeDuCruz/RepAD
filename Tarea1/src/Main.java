import java.io.File;
import java.io.IOException;

public class Main{
    public static void main(String[] args) {
        System.out.println(eDirectorio("/home/dam/Documentos/AcesoDatos"));
        System.out.println(eFicheiro("/home/dam/Documentos/AcesoDatos"));
        //creaDirectorio("/home/dam/Documentos/AcesoDatos/Tarea1/pruebaDirectorio");
        //creaFicheiro("/home/dam/Documentos/AcesoDatos/Tarea1/pruebaDirectorio","Prueba");ç
        //modoAcceso("/home/dam/Documentos/AcesoDatos/Tarea1/pruebaDirectorio","Prueba");
        System.out.println(calculaLonxitude("/home/dam/Documentos/AcesoDatos/Tarea1/pruebaDirectorio","Prueba"));
        mLectura("/home/dam/Documentos/AcesoDatos/Tarea1/pruebaDirectorio","Prueba");

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

    public static void modoAcceso(String dirName,String fileName){
        File archivo = new File(dirName,fileName);
        boolean lectura, esritura;
        lectura=archivo.canRead();
        esritura=archivo.canWrite();
        if (lectura){
            System.out.println("Se puede leer");
        }else {
            System.out.println("No se puede leer");
        }

        if (esritura){
            System.out.println("Se puede escribir");
        }else {
            System.out.println("No se puede escribir");
        }
    }

    public static long calculaLonxitude(String dirName, String fileName){
        File archivo = new File(dirName,fileName);
        return archivo.length();
    }

    public static void mLectura(String dirName,String fileName){
        File archivo = new File(dirName,fileName);
        if (archivo.setReadOnly()){
            System.out.println("Archivo en solo lectura");
        }else {
            System.out.println("El archivo no pudo ser modificado");
        }
    }
}//end class