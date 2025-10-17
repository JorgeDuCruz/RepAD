package models;

import javax.persistence.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Entity
@Table( name = "pokemon")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "nacemento")
    private Date nacemento;

    @Column(name = "pokedexentry", nullable = true)
    private int pokedexentry;

    @Column(name = "adestrador",nullable = true)
    private int adestrador;

    public Pokemon(String nome, String nacemento) {
        this.nome = nome;
        setNacemento(nacemento);
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

    public Date getNacemento() {
        return nacemento;
    }

    public void setNacemento(Date nacemento) {
        this.nacemento = nacemento;
    }

    public void setNacemento(String nacemento){
        this.nacemento = stringToDate(nacemento);
    }

    public int getPokedexentry() {
        return pokedexentry;
    }

    public void setPokedexentry(int pokedexentry) {
        this.pokedexentry = pokedexentry;
    }

    public int getAdestrador() {
        return adestrador;
    }

    public void setAdestrador(int adestrador) {
        this.adestrador = adestrador;
    }

    public String toString(){
        return "ID: "+id+"\n" +
                "Nome: "+nome+"\n"+
                "Nacemento: "+nacemento+"\n" +
                "Pokedexentry: "+pokedexentry+"\n" +
                "Adestrador: "+adestrador;
    }

    public static Date stringToDate(String dataStr) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date dataUtil = formato.parse(dataStr);
            return new Date(dataUtil.getTime());
        } catch (ParseException e) {
            System.out.println("petou "+ e.getMessage());
            return null;
        }
    }
}
