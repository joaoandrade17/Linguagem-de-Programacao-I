package atividadedois.classes;

public class Esporte {

    private int id;
    private String nome;
    private String lugar;
    private int jogadores;

    public Esporte() {
    }

    public Esporte(int id, String nome, String lugar, int jogadores) {
        this.id = id;
        this.nome = nome;
        this.lugar = lugar;
        this.jogadores = jogadores;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getLugar() { return lugar; }
    public void setLugar(String lugar) { this.lugar = lugar; }

    public int getJogadores() { return jogadores; }
    public void setJogadores(int jogadores) { this.jogadores = jogadores; }
}
