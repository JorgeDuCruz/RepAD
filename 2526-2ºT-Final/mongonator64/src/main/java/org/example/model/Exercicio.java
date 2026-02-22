package org.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Exercicios")
public class Exercicio {
    @Id
    private String id;

    private String exercicio;
    private List<Videoxogo> videoxogos;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExercicio() {
        return exercicio;
    }

    public void setExercicio(String exercicio) {
        this.exercicio = exercicio;
    }

    public List<Videoxogo> getVideoxogos() {
        return videoxogos;
    }

    public void setVideoxogos(List<Videoxogo> videoxogos) {
        this.videoxogos = videoxogos;
    }
}
