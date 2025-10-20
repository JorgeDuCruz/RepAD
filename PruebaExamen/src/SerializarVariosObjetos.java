import java.io.*;

public class SerializarVariosObjetos {

    public static void serializarVehiculos(Vehiculo vehiculo){
        try {
            BufferedOutputStream esc = new BufferedOutputStream(new FileOutputStream("tablaVehiculos.veh",true));
            ObjectOutputStream escribir = new ObjectOutputStream(esc);
            escribir.writeObject(vehiculo);
            escribir.close();
            esc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fallo con el fichero tablaVehiculo.veh "+e.getMessage());
        } catch (IOException e) {
            System.out.println("Fallo al guardar en fichero "+e.getMessage());
        }
    }
}
