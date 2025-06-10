package atividadedois.classes;

public class Instrumento {

    private int id;
    private String nome;
    private String tipo;
    private String marca;

    public Instrumento() {
    }

    public Instrumento(int id, String nome, String tipo, String marca) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.marca = marca;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
}
