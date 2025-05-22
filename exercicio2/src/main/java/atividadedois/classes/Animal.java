package atividadedois.classes;

public class Animal {
    private String especie;
    private float peso;
    private float comprimento;


    public Animal(String especie, float peso, float comprimento) {
        this.especie = especie;
        this.peso = peso;
        this.comprimento = comprimento;
    }


    public void correr() {
        System.out.println(especie + " está correndo.");
    }

    public void comer() {
        System.out.println(especie + " está comendo.");
    }

    public void dormir() {
        System.out.println(especie + " está dormindo.");
    }
}

