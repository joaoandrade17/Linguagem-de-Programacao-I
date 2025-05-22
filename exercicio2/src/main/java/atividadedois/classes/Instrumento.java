package atividadedois.classes;

public class Instrumento {
    private String nome;
    private String tipo;
    private String marca;


    public Instrumento(String nome, String tipo, String marca) {
        this.nome = nome;
        this.tipo = tipo;
        this.marca = marca;
    }


    public void tocar() {
        System.out.println(nome + " está tocando, que belo som!.");
    }

    public void afinar() {
        System.out.println(nome + " foi afinado.");
    }

    public void limpar() {
        System.out.println(nome + " foi limpo.");
    }
}
