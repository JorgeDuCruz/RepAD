package Parte2;

import java.io.Serializable;

public class ProductoTransient implements Serializable {
    private String nome;
    private transient int stock;
    private double prezo;

    public ProductoTransient(String nome, int stock, double prezo){
        this.nome = nome;
        this.prezo = prezo;
        this.stock = stock;
    }

    @Override
    public String toString(){
        return "Producto: "+nome+" Stock: "+stock+" Prezo: "+prezo;
    }
}
