package Parte1;

import java.io.Serializable;

/**
 * Clase que represanta los datos de un producto
 */
public class Producto implements Serializable {
    private String nome;
    private int stock;
    private double prezo;

    public Producto(String nome, int stock, double prezo){
        this.nome = nome;
        this.prezo = prezo;
        this.stock = stock;
    }

    @Override
    public String toString(){
        return "Producto: "+nome+" Stock: "+stock+" Prezo: "+prezo;
    }
}
