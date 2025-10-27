package Services;

import models.Adestrador;

import javax.xml.stream.*;
import java.io.*;
import java.util.ArrayList;

public class ServiceXMLAdestrador {
    private static String fichero = "Adestradores.xml";

    public static void exportarXML(ArrayList<Adestrador> adestradores){
        XMLOutputFactory n1 = XMLOutputFactory.newInstance();
        try {
            XMLStreamWriter esc = n1.createXMLStreamWriter(new FileWriter(fichero));

            esc.writeStartDocument();
            esc.writeStartElement("Adestradores");
            for (Adestrador adestrador:adestradores){
                esc.writeStartElement("Adestrador");
                esc.writeAttribute("ID",""+adestrador.getId());

                esc.writeStartElement("Nome");
                esc.writeCharacters(adestrador.getNome());
                esc.writeEndElement();

                esc.writeStartElement("Nacemento");
                esc.writeCharacters(""+adestrador.getNacemento());
                esc.writeEndElement();

                esc.writeEndElement();
            }
            esc.writeEndElement();
            esc.close();
        } catch (IOException e) {
            System.out.println("Error con el fichero adestrador.xml "+e.getMessage());
        } catch (XMLStreamException e) {
            System.out.println("Error con el servicio XML "+e.getMessage());
        }

    }

    public static ArrayList<Adestrador> importarXML(){
        XMLInputFactory l1 = XMLInputFactory.newInstance();
        ArrayList<Adestrador> list = new ArrayList<>();
        Adestrador aux = new Adestrador();
        try {
            XMLStreamReader ler = l1.createXMLStreamReader(new FileReader(fichero));
            while (ler.hasNext()) {
                int event = ler.next();

                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        if ("Adestrador".equals(ler.getLocalName())) {
                            String id = ler.getAttributeValue(0);
                            aux.setId(Integer.parseInt(id));
                        }
                        if ("Nome".equals(ler.getLocalName())) {
                            String nome = ler.getElementText();
                            aux.setNome(nome);
                        }
                        if ("Nacemento".equals(ler.getLocalName())) {
                            String nacemento = ler.getElementText();
                            aux.setNacemento(nacemento);
                        }
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        if ("Adestrador".equals((ler.getLocalName()))){
                            list.add(aux);
                            aux = new Adestrador();
                        }
                        break;

                    default:
                        // Otros eventos (como texto o comentarios)
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer adestradores.xml "+e.getMessage());
        } catch (XMLStreamException e) {
            System.out.println("Error con el servicio de lectura de XML "+e.getMessage());
        }
        return list;
    }
}
