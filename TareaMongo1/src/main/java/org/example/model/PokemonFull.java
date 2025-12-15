package org.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "pokemonFull")
public class PokemonFull {
    @Id
    private String id;



    private String nome;
    private ArrayList<String> tipo;
    private int nivel;
    private ArrayList<String> habilidades;
    private AdestradorFull adestrador;

    public PokemonFull() {
    }

    public PokemonFull(String id, String nome, ArrayList<String> tipo, int nivel, ArrayList<String> habilidades, AdestradorFull adestrador) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.nivel = nivel;
        this.habilidades = habilidades;
        this.adestrador = adestrador;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<String> getTipo() {
        return tipo;
    }

    public void setTipo(ArrayList<String> tipo) {
        this.tipo = tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public ArrayList<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<String> habilidades) {
        this.habilidades = habilidades;
    }

    public AdestradorFull getAdestrador() {
        return adestrador;
    }

    public void setAdestrador(AdestradorFull adestrador) {
        this.adestrador = adestrador;
    }
}
