package atividadedois.classes;

public class Planta {
    private String nome;
    private String tipo;
    private String ambiente;


    public Planta(String nome, String tipo, String ambiente) {
        this.nome = nome;
        this.tipo = tipo;
        this.ambiente = ambiente;
    }


    public void regar() {
        System.out.println(nome + " foi regada.");
    }

    public void plantar() {
        System.out.println(nome + " foi plantada com sucesso.");
    }

    public void colher() {
        System.out.println(nome + " foi colhida.");
    }
}
