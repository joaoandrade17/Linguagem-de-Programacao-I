package atividadedois.classes;

public class Esporte {
    private String nome;
    private String local;
    private int numJogadores;


    public Esporte(String nome,String local, int numJogadores) {
        this.nome = nome;
        this.local = local;
        this.numJogadores = numJogadores;
    }


    public void iniciar() {
        System.out.println(nome + " está começando.");
    }

    public void encerrar() {
        System.out.println(nome + " está finalizando.");
    }

    public void informarGanhador() {
        System.out.println(nome + " teve um vencedor!.");
    }
}
