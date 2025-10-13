import java.io.Serializable;

public class Vehiculo implements Serializable {
    private int id;
    private String modelo;
    private String marca;
    private int ano;
    private String descipcion;

    public Vehiculo(int id, String modelo, String marca, int ano, String descipcion) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.descipcion = descipcion;
    }

    public Vehiculo(String modelo, String marca, int ano, String descipcion) {
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.descipcion = descipcion;
    }

    public int getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public int getAno() {
        return ano;
    }

    public String getDescipcion() {
        return descipcion;
    }

    @Override
    public String toString(){
        return "id = "+id+" Modelo = "+modelo+" Marca = "+marca+" Ano = "+ano+" Descripción = "+descipcion;
    }
}
