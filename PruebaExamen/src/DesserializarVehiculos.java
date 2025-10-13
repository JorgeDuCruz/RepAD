import java.io.*;
import java.sql.Connection;
import java.util.ArrayList;

public class DesserializarVehiculos {
    public static ArrayList<Vehiculo> desserializarVehiculos(){
        ArrayList<Vehiculo> result=null;
        try {
            BufferedInputStream ler = new BufferedInputStream(new FileInputStream("tablaVehiculo.veh"));
            ObjectInputStream leer = new ObjectInputStream(ler);
             result = (ArrayList<Vehiculo>) leer.readObject();

        } catch (FileNotFoundException e) {
            System.out.println("Fallo con el fichero tablaVehiculo.veh "+e.getMessage());
        } catch (IOException e) {
            System.out.println("Fallo al guardar en fichero "+e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Fallo con la clase Vehiculo "+e.getMessage());
        }
        return result;
    }
}
