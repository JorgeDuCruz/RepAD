import java.io.Serializable;

public class Vehiculo implements Serializable {
    private int id;
    private String modelo;
    private String marca;
    private int ano;
    private String descripcion;

    public Vehiculo(int id, String modelo, String marca, int ano, String descripcion) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.descripcion = descripcion;
    }

    public Vehiculo(String modelo, String marca, int ano, String descripcion) {
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.descripcion = descripcion;
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
        return descripcion;
    }

    @Override
    public String toString(){
        return "id = "+id+" Modelo = "+modelo+" Marca = "+marca+" Ano = "+ano+" Descripción = "+ descripcion;
    }
}
