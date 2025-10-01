package Model;

/**
 * Clase Libro que representa un libro.
 * @author Jorge
 *  @version 1.0
 */
public class Libro {
    private String titulo;
    private String isbn;
    private String autor;
    private int anoPublicacion;
    private String editorial;
    private int numPaginas;

    public Libro(String titulo, String isbn, String autor, int anoPublicacion, String editorial, int numPaginas) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.anoPublicacion = anoPublicacion;
        this.editorial = editorial;
        this.numPaginas = numPaginas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacion() {
        return anoPublicacion;
    }

    public void setAnoPublicacion(int anoPublicacion) {
        this.anoPublicacion = anoPublicacion;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }
}
