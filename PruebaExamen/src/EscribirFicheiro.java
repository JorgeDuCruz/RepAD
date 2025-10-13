import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class EscribirFicheiro {

    public static void escribri(ArrayList<Vehiculo> list){
        try {
            BufferedOutputStream esc = new BufferedOutputStream(new FileOutputStream("Fichero.txt"));
            DataOutputStream escribir = new DataOutputStream(esc);
            for (Vehiculo vehiculo:list){
                escribir.writeUTF(vehiculo.toString());
            }
            escribir.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fallo con el fichero txt "+e.getMessage());
        } catch (Exception e) {
            System.out.println("Fallo "+e.getMessage());
        }
    }
}
