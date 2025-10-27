package Services;

import models.Pokedex;

import java.io.*;
import java.util.ArrayList;

public class SerivceSerializacionPokedex {

    public static void serializar(Pokedex pokedex,ObjectOutputStream esc){
        try {
            esc.writeObject(pokedex);
        }catch (FileNotFoundException e){
            System.out.println("Fichero no encontrado "+e.getMessage());
        }
        catch (IOException e) {
            System.out.println("Error al escribir el fichero de pokedex "+e.getMessage());
        }
    }

    public static ArrayList<Pokedex> desSerializar(){
        ArrayList<Pokedex> list = new ArrayList<>();
        try {
            ObjectInputStream leer = new ObjectInputStream(new BufferedInputStream(new FileInputStream("Pokedex.dex")));
            Pokedex aux=(Pokedex) leer.readObject();
            while (aux != null){
                    list.add(aux);
                    aux = (Pokedex) leer.readObject();
            }
            leer.close();

        }
        catch (EOFException e){
            System.out.println("Leido");;
        }
        catch (IOException e) {
            System.out.println("Error al leer el fichero pokedex "+e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Problema con la clase pokedex");
        }
        return list;
    }
}
