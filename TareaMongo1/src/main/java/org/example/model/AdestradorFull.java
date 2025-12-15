package org.example.model;

public class AdestradorFull {
    private String nome;
    private int idade;
    private String ciudade;

    public AdestradorFull(String nome, int idade, String ciudade) {
        this.nome = nome;
        this.idade = idade;
        this.ciudade = ciudade;
    }

    public AdestradorFull() {
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
