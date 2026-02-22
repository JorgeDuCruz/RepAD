package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "poder")
public class Poder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private Integer nivel;

    // COSNTRUCTORES

    public Poder() { }

    public Poder(Long id, String nombre, String descripcion, Integer nivel) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }
}