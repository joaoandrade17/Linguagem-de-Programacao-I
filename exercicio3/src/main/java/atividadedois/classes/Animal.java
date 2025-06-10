package atividadedois.classes;

public class Animal {

    private int id;
    private String especie;
    private double peso;
    private int comprimento;

    public Animal() {
    }

    public Animal(int id, String especie, double peso, int comprimento) {
        this.id = id;
        this.especie = especie;
        this.peso = peso;
        this.comprimento = comprimento;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public int getComprimento() { return comprimento; }
    public void setComprimento(int comprimento) { this.comprimento = comprimento; }
}

