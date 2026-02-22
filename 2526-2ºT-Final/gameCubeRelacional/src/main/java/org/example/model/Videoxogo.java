package org.example.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "videoxogo")
public class Videoxogo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titulo;

    @Column(name = "data_lanzamento")
    private LocalDate dataLanzamento;

    private String desenvolvedor;
    private String plataforma;
    private String categoria;

    @ManyToOne
    @JoinColumn(name = "protagonista_id", nullable = false)
    private Protagonista protagonista;

    @ManyToOne
    @JoinColumn(name = "inimigo_id", nullable = false)
    private Inimigo inimigo;

    // COSNTRUCTORES

    public Videoxogo() { }

    public Videoxogo(Long id, String titulo, LocalDate dataLanzamento, String desenvolvedor, String plataforma, String categoria, Protagonista protagonista, Inimigo inimigo) {
        this.id = id;
        this.titulo = titulo;
        this.dataLanzamento = dataLanzamento;
        this.desenvolvedor = desenvolvedor;
        this.plataforma = plataforma;
        this.categoria = categoria;
        this.protagonista = protagonista;
        this.inimigo = inimigo;
    }

    // SETTERS Y GETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getDataLanzamento() {
        return dataLanzamento;
    }

    public void setDataLanzamento(LocalDate dataLanzamento) {
        this.dataLanzamento = dataLanzamento;
    }

    public String getDesenvolvedor() {
        return desenvolvedor;
    }

    public void setDesenvolvedor(String desenvolvedor) {
        this.desenvolvedor = desenvolvedor;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Protagonista getProtagonista() {
        return protagonista;
    }

    public void setProtagonista(Protagonista protagonista) {
        this.protagonista = protagonista;
    }

    public Inimigo getInimigo() {
        return inimigo;
    }

    public void setInimigo(Inimigo inimigo) {
        this.inimigo = inimigo;
    }

}
