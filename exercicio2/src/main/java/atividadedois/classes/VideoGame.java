package atividadedois.classes;

public class VideoGame {
    private String nome;
    private int geracao;
    private String fabricante;


    public VideoGame(String nome, int geracao, String fabricante) {
        this.nome = nome;
        this.geracao = geracao;
        this.fabricante = fabricante;
    }


    public void ligar() {
        System.out.println(nome + " foi ligado.");
    }

    public void desligar() {
        System.out.println(nome + " foi desligado.");
    }

    public void inserirDisco() {
        System.out.println(" disco inserido, carregando...");
    }
}
