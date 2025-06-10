package atividadedois.classes;

public class Planta {

    private int id;
    private String nome;
    private String tipo;
    private String ambiente;

    public Planta() {
    }

    public Planta(int id, String nome, String tipo, String ambiente) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.ambiente = ambiente;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getAmbiente() { return ambiente; }
    public void setAmbiente(String ambiente) { this.ambiente = ambiente; }
}
