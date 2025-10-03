package Parte2;

import Parte1.Producto;

import java.io.*;

public class Parte2 {
    public static void main(String[] args) {
        ProductoTransient p1 = new ProductoTransient("Balas de plata",60,0.25);
        gardarProducto(p1);
        ProductoTransient p2 = cargarProducto();
        System.out.println(p1);
        System.out.println(p2);
    }

    public static void gardarProducto(ProductoTransient p1){
        try{
            ObjectOutputStream gardar = new ObjectOutputStream(new FileOutputStream("src/Parte2/serialT.txt"));
            gardar.writeObject(p1);
        } catch (IOException e) {
            System.out.println("Error al encotrar fichero "+e.getMessage());
        }
    }

    public static ProductoTransient cargarProducto(){
        ProductoTransient p2=null;
        try {
            ObjectInputStream cargar = new ObjectInputStream(new FileInputStream("src/Parte2/serialT.txt"));
            p2 = (ProductoTransient) cargar.readObject();
        } catch (IOException e) {
            System.out.println("Error al encontrar fichero "+e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Clase de objeto no valida");
        }
        return p2;
    }
}
