package models;

import javax.persistence.*;
import java.beans.ConstructorProperties;

@Entity
@Table(name = "pokedex")
public class Pokedex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "peso")
    private double peso;

    @Column(name = "misc")
    private String misc;

    public Pokedex() {} //Constructor por defecto para Hibernate

    public Pokedex(String nome, double peso, String misc) {
        this.nome = nome;
        this.peso = peso;
        this.misc = misc;
    }

    public Pokedex(int id,String nome, double peso, String misc) {
        this.id=id;
        this.nome = nome;
        this.peso = peso;
        this.misc = misc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getMisc() {
        return misc;
    }

    public void setMisc(String misc) {
        this.misc = misc;
    }

    public String toString(){
        return "ID: "+id+"\n" +
                "Nome: "+nome+"\n"+
                "Peso: "+peso+"\n" +
                "Misc: "+misc;
    }
}
