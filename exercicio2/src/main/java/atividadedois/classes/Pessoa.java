package atividadedois.classes;

public class Pessoa {
    private String nome;
    private int idade;
    private float altura;


    public Pessoa(String nome, int idade, float altura) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }


    public void falar() {
        System.out.println(nome + " está falando.");
    }

    public void comer() {
        System.out.println(nome + " está comendo.");
    }

    public void andar() {
        System.out.println(nome + " está andando.");
    }
}

