package atividadedois.classes;

public class Videogame {

    private int id;
    private String nome;
    private String geracao;
    private String fabricante;

    public Videogame() {
    }

    public Videogame(int id, String nome, String geracao, String fabricante) {
        this.id = id;
        this.nome = nome;
        this.geracao = geracao;
        this.fabricante = fabricante;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getGeracao() { return geracao; }
    public void setGeracao(String geracao) { this.geracao = geracao; }

    public String getFabricante() { return fabricante; }
    public void setFabricante(String fabricante) { this.fabricante = fabricante; }
}
