public class Animais {
    private int id;
    private String nome;
    private String especie;
    private int cantidade;

    public Animais(int id, String nome, String especie, int cantidade) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        setCantidade(cantidade);
    }

    public void setCantidade(int cantidade) {
        if (cantidade>=0) this.cantidade = cantidade;
        else this.cantidade = 0;
    }
}
