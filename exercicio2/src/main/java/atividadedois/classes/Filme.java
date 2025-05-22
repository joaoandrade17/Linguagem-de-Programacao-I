package atividadedois.classes;

public class Filme {
    private String nome;
    private String genero;
    private int ano;


    public Filme(String nome, int ano, String genero) {
        this.nome = nome;
        this.ano = ano;
        this.genero = genero;
    }


    public void assistir() {
        System.out.println(nome + " foi visto.");
    }

    public void recomendar() {
        System.out.println(nome + " foi recomendado.");
    }

    public void avaliar() {
        System.out.println(nome + " foi avaliado.");
    }
}
