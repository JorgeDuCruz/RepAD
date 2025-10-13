public class Inventario {
    private int id;
    private int idV;
    private double prezoM;
    private double prezoV;
    private int porcentaxeOferta;

    public Inventario(int id, int idV, double prezoM, double prezoV, int porcentaxeOferta) {
        this.id = id;
        this.idV = idV;
        this.prezoM = prezoM;
        this.prezoV = prezoV;
        this.porcentaxeOferta = porcentaxeOferta;
    }

    public Inventario(int idV, double prezoM, double prezoV, int porcentaxeOferta) {
        this.idV = idV;
        this.prezoM = prezoM;
        this.prezoV = prezoV;
        this.porcentaxeOferta = porcentaxeOferta;
    }

    public int getId() {
        return id;
    }

    public int getIdV() {
        return idV;
    }

    public double getPrezoM() {
        return prezoM;
    }

    public double getPrezoV() {
        return prezoV;
    }

    public int getPorcentaxeOferta() {
        return porcentaxeOferta;
    }

    public void setPorcentaxeOferta(int porcentaxeOferta) {
        this.porcentaxeOferta = porcentaxeOferta;
    }
}
