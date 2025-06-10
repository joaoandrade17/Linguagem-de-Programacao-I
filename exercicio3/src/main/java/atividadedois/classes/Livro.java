package atividadedois.classes;

public class Livro {

    private int id;
    private String nome;
    private int paginas;
    private String autor;

    public Livro() {
    }

    public Livro(int id, String nome, String autor, int paginas) {
        this.id = id;
        this.nome = nome;
        this.autor = autor;
        this.paginas = paginas;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public int getPaginas() { return paginas; }
    public void setPaginas(int paginas) { this.paginas = paginas; }

}