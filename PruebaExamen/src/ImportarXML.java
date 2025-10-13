import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

public class ImportarXML {
    public static void importarXML(Connection con){
        XMLOutputFactory n1 = XMLOutputFactory.newInstance();
        try {
            XMLStreamWriter escribir = n1.createXMLStreamWriter(new FileWriter("vehiculos.xml"));
            ArrayList<Vehiculo> list = ServicioVehiculo.leerVehiculos(con);
            int nVehiculo = 1;
            escribir.writeStartDocument();
            escribir.writeStartElement("Vehiculos");
            for (Vehiculo vehiculo:list){
                escribir.writeStartElement("vehiculo"+nVehiculo);
                escribir.writeAttribute("id",""+vehiculo.getId());
                escribir.writeStartElement("Modelo");
                escribir.writeCharacters(vehiculo.getModelo());
                escribir.writeEndElement();
                escribir.writeStartElement("Marca");
                escribir.writeCharacters(vehiculo.getMarca());
                escribir.writeEndElement();
                escribir.writeStartElement("Ano");
                escribir.writeCharacters(""+vehiculo.getAno());
                escribir.writeEndElement();
                escribir.writeStartElement("Descripción");
                escribir.writeCharacters(vehiculo.getDescipcion());
                escribir.writeEndElement();
                escribir.writeEndElement();
                nVehiculo++;
            }
            escribir.writeEndElement();
            escribir.close();
        } catch (XMLStreamException e) {
            System.out.println("Fallo con el xml "+e.getMessage());
        } catch (IOException e) {
            System.out.println("Fallo con el fichero "+e.getMessage());
        }
    }
}
