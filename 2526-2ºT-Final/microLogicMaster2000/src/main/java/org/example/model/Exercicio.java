package org.example.model;



import java.util.List;

public class Exercicio {
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

    @Override
    public String toString() {
        return "Exercicio{" +
                "id=" + id +
                ", exercicio='" + exercicio + '\'' +
                ", videoxogos=" + videoxogos +
                '}';
    }
}
