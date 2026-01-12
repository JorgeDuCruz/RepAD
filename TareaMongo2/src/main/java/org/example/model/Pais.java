package org.example.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "Paises")
public class Pais {

    @Id
    private String id;

    private String nome;
    private String organizacion;
    private ArrayList<String> partidos;

    //gardamos o ID do presidente
    private String id_presidente;

    // ---- GETTERS & SETTERS ----


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

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public ArrayList<String> getPartidos() {
        return partidos;
    }

    public void setPartidos(ArrayList<String> partidos) {
        this.partidos = partidos;
    }

    public String getId_presidente() {
        return id_presidente;
    }

    public void setId_presidente(String id_presidente) {
        this.id_presidente = id_presidente;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", organizacion='" + organizacion + '\'' +
                ", partidos=" + partidos +
                ", id_presidente='" + id_presidente + '\'' +
                '}';
    }
}