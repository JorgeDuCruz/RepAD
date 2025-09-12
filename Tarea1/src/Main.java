import java.io.File;
import java.io.IOException;
import java.sql.ClientInfoStatus;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        System.out.println(eDirectorio("/home/dam/Documentos/AcesoDatos"));
        System.out.println(eFicheiro("/home/dam/Documentos/AcesoDatos"));
        //creaDirectorio("/home/dam/Documentos/AcesoDatos/Tarea1/pruebaDirectorio/pruebaDir");
        //creaFicheiro("/home/dam/Documentos/AcesoDatos/Tarea1/pruebaDirectorio/pruebaDir","Prueba");
        //modoAcceso("/home/dam/Documentos/AcesoDatos/Tarea1/pruebaDirectorio","Prueba");
        System.out.println(calculaLonxitude("/home/dam/Documentos/AcesoDatos/Tarea1/pruebaDirectorio","Prueba"));
        //mLectura("/home/dam/Documentos/AcesoDatos/Tarea1/pruebaDirectorio","Prueba");
        //mEscritura("/home/dam/Documentos/AcesoDatos/Tarea1/pruebaDirectorio","Prueba");
        //borraFicheiro("/home/dam/Documentos/AcesoDatos/Tarea1/pruebaDirectorio","Prueba");
        //borraDirectorio("/home/dam/Documentos/AcesoDatos/Tarea1/pruebaDirectorio");
        //mContido("/home/dam/Documentos/AcesoDatos/Tarea1/pruebaDirectorio");
        recur(new File("/home/dam/Documentos/AcesoDatos/Tarea1/pruebaDirectorio"));

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

    public static void mEscritura(String dirName,String fileName){
        File archivo = new File(dirName,fileName);
        if (archivo.setWritable(true)){
            System.out.println("Archivo permite escribir");
        }else {
            System.out.println("El archivo no pudo ser modificado");
        }
    }

    public static void borraFicheiro(String dirName,String fileName){
        File archivo = new File(dirName,fileName);
        boolean resultado = archivo.delete();
        if (resultado){
            System.out.println("Archivo eliminado");
        }else {
            System.out.println("Archivo inexistente");
        }
    }


    public static void borraDirectorio(String dirName){
        File archivo = new File(dirName);
        boolean resultado = archivo.delete();
        if (resultado){
            System.out.println("Directorio eliminado");
        }else {
            System.out.println("Directorio inexistente");
        }
    }

    /**
     * Funcion que recibe la ruta de un directorio y muestra el resultado
     * @param dirName ruta del dirtectorio
     * @return un array de Strings (String[]) con el listado que muestra
     */
    public static String[] mContido(String dirName){
        File archivo = new File(dirName);
        String[] listado = archivo.list();
        System.out.println(Arrays.toString(listado));
        return listado;
    }

    public static void recur(File padre){
        String[] listado = mContido(padre.getPath());

        if (listado!=null){
            File archivo;
            for (String ruta:listado){
                archivo = new File(padre.getPath(),ruta);
                if (archivo.isDirectory()){
                    System.out.println(ruta+": ");
                    recur(archivo);
                }
            }
        }

    }
}//end class