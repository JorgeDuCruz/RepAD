import java.io.File;
public class Main{
    public static void main(String[] args) {
        System.out.println(eDirectorio("/home/dam/Documentos/AcesoDatos"));
        System.out.println(eFicheiro("/home/dam/Documentos/AcesoDatos"));
        creaDirectorio("/home/dam/Documentos/AcesoDatos/Tarea1/pruebaDirectorio");
    }//en static


    public static boolean eDirectorio(String cadea){
        File archivo = new File(cadea);
        return archivo.isDirectory();
    }
    public static boolean eFicheiro(String cadea){
        File archivo = new File(cadea);
        if(archivo.isFile()){
            return true;
        }else{
            return false;
        }

    }
    public static void creaDirectorio(String cadea){
        File archivo = new File(cadea);
        boolean creado = archivo.mkdir();
        if(creado){
            System.out.printf("Archivo creado");
        }else{
            System.out.println("No se ha creado");
        }
    }


    public static void creaFicheiro(String dirName, String fileName){
        File archivo = new File(dirName);

    }
}//end class