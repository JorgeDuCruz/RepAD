package Parte3;

import javax.sql.rowset.spi.XmlReader;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Parte3 {
    public static void main(String[] args) {
        XMLOutputFactory n1 = XMLOutputFactory.newInstance();
        try {
            XMLStreamWriter escribir = n1.createXMLStreamWriter(new FileWriter("src/Parte3/parte3.xml"));


            escribir.writeStartDocument("1.0"); //Version del xml

            escribir.writeStartElement("autores"); // Elemento raiz

            //empieza la etiqueta autor1
            escribir.writeStartElement("autor");
            escribir.writeAttribute("codigo","a1"); // Atributo del autor

            //Contenido de autor
            //nombre
            escribir.writeStartElement("nome");
            escribir.writeCharacters("Alexandre Dumas");
            escribir.writeEndElement();
            //Titulo
            escribir.writeStartElement("titulo");
            escribir.writeCharacters("El conde de montecristo");
            escribir.writeEndElement();
            //Titulo
            escribir.writeStartElement("titulo");
            escribir.writeCharacters("Los miserables ");
            escribir.writeEndElement();

            //cerrar autor1
            escribir.writeEndElement();

            //empieza la etiqueta autor2
            escribir.writeStartElement("autor");
            escribir.writeAttribute("codigo","a2"); // Atributo del autor

            //Contenido de autor
                //nombre
            escribir.writeStartElement("nome");
            escribir.writeCharacters("Fiodor Dostoyevski");
            escribir.writeEndElement();
                //Titulo
            escribir.writeStartElement("titulo");
            escribir.writeCharacters(" El idiota");
            escribir.writeEndElement();
                //Titulo
            escribir.writeStartElement("titulo");
            escribir.writeCharacters("Noches blancas");
            escribir.writeEndElement();

            //cerrar autor2
            escribir.writeEndElement();




            //cerrar autores
            escribir.writeEndElement();


            escribir.close();

        } catch (IOException e) {
            System.out.println("Error al encontrar fichero "+e.getMessage());
        } catch (XMLStreamException e) {
            System.out.println("Error con el xml "+e.getMessage());
        }
    }

}
