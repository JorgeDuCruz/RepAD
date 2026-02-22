package org.example.model;



public class Inimigo {


    private Long id;

    private String nombre;
    private String poder;
    private Integer nivel;

    // COSNTRUCTORES

    public Inimigo() { }

    public Inimigo(Long id, String nombre, String poder, Integer nivel) {
        this.id = id;
        this.nombre = nombre;
        this.poder = poder;
        this.nivel = nivel;
    }

    // SETTERS Y GETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPoder() {
        return poder;
    }

    public void setPoder(String poder) {
        this.poder = poder;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }
}
