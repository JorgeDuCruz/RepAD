package org.example.model;




public class Protagonista {

    private Long id;

    private String nombre;
    private Integer edad;
    private String historia;

    private Poder poder;

    // COSNTRUCTORES

    public Protagonista() { }

    public Protagonista(Long id, String nombre, Integer edad, String historia, Poder poder) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.historia = historia;
        this.poder = poder;
    }

    @Override
    public String toString() {
        return "Protagonista{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", historia='" + historia + '\'' +
                ", poder=" + poder +
                '}';
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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public Poder getPoder() {
        return poder;
    }

    public void setPoder(Poder poder) {
        this.poder = poder;
    }
}
