import java.io.*;
import java.sql.Connection;
import java.util.ArrayList;

public class SerializarVehiculo {
    public static void serializarVehiculos(Connection con){
        try {
            ArrayList<Vehiculo> list = ServicioVehiculo.leerVehiculos(con);
            BufferedOutputStream esc = new BufferedOutputStream(new FileOutputStream("tablaVehiculo.veh"));
            ObjectOutputStream escribir = new ObjectOutputStream(esc);
            escribir.writeObject(list);
            escribir.close();
            esc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fallo con el fichero tablaVehiculo.veh "+e.getMessage());
        } catch (IOException e) {
            System.out.println("Fallo al guardar en fichero "+e.getMessage());
        }
    }
}
