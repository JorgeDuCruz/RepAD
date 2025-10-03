package Parte1;

import java.io.*;

public class Parte1 {
    public static void main(String[] args) {
        Producto p1 = new Producto("Balas de plata",60,0.25);
        gardarProducto(p1);
        Producto p2 = cargarProducto();
        System.out.println(p1);
        System.out.println(p2);
    }

    public static void gardarProducto(Producto p1){
        try{
            ObjectOutputStream gardar = new ObjectOutputStream(new FileOutputStream("serial.txt"));
            gardar.writeObject(p1);
        } catch (IOException e) {
            System.out.println("error al encotrar fichero "+e.getMessage());
        }
    }

    public static Producto cargarProducto(){
        Producto p2=null;
        try {
            ObjectInputStream cargar = new ObjectInputStream(new FileInputStream("serial.txt"));
            p2 = (Producto) cargar.readObject();
        } catch (IOException e) {
            System.out.println("Error al encontrar fichero "+e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Clase de objeto no valida");
        }
        return p2;
    }
}