package atividadedois.classes;

public class Streaming {
    private String nome;
    private float preco;
    private String filmes;
    private String series;



    public Streaming(String nome, float preco, String filmes, String series) {
        this.nome = nome;
        this.filmes = filmes;
        this.series = series;
        this.preco = preco;
    }


    public void assistir() {
        System.out.println(nome + " está reproduzindo");
    }

    public void pausar() {
        System.out.println(nome + " foi pausado.");
    }

    public void avaliar() {
        System.out.println(nome + " foi avaliado.");
    }
}
