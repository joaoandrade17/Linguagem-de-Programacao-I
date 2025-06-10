package atividadedois.classes;

public class Carro {

    private int id;
    private String modelo;
    private int ano;
    private String fabricante;

    public Carro() {
    }

    public Carro(int id, String modelo, int ano, String fabricante) {
        this.id = id;
        this.modelo = modelo;
        this.ano = ano;
        this.fabricante = fabricante;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }

    public String getFabricante() { return fabricante; }
    public void setFabricante(String fabricante) { this.fabricante = fabricante; }
}
