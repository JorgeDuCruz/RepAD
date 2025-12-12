package org.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Adestradores")
public class Adestrador {
    @Id
    private String id;
    private String nome;
    private int idade;
    private String ciudade;

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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCiudade() {
        return ciudade;
    }

    public void setCiudade(String ciudade) {
        this.ciudade = ciudade;
    }
}
