package atividadedois.classes;

public class Livro {
    private String nome;
    private int paginas;
    private String autor;


    public Livro(String nome, int paginas, String autor) {
        this.nome = nome;
        this.paginas = paginas;
        this.autor = autor;
    }


    public void ler() {
        System.out.println(nome + " lendo...");
    }

    public void guardar() {
        System.out.println(nome + " foi guardado.");
    }

    public void emprestar() {
        System.out.println(nome + " foi emprestado.");
    }
}
