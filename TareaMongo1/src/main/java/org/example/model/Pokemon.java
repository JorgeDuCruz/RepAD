package org.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.reflect.Array;

@Document(collection = "Pokemons")
public class Pokemon {

    @Id
    private String id;



    private String nome;
    private Array tipo;
    private int nivel;
    private Array habilidades;
    private String id_adestrador;

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

    public Array getTipo() {
        return tipo;
    }

    public void setTipo(Array tipo) {
        this.tipo = tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Array getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(Array habilidades) {
        this.habilidades = habilidades;
    }

    public String getId_adestrador() {
        return id_adestrador;
    }

    public void setId_adestrador(String id_adestrador) {
        this.id_adestrador = id_adestrador;
    }
}
