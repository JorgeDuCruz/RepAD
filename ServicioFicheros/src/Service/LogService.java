package Service;

import Config.ConfigLog;
import Model.Libro;
import Model.Log;

import java.io.*;

public class LogService {
    private static String fichero = ConfigLog.ficheroLogs;
    public static void guardarRegistro(Log log){
        try {
            BufferedOutputStream es = new BufferedOutputStream(new FileOutputStream(fichero,true));
            ObjectOutputStream registrar = new ObjectOutputStream(es);
            registrar.writeObject(log);
        } catch (FileNotFoundException e) {
            System.out.println("Error al cargar fichero log "+e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al registrar objeto log "+e.getMessage());
        }
    }

    public static void leer(){

    }
}
