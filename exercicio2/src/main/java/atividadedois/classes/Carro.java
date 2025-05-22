package atividadedois.classes;

public class Carro {
    private String modelo;
    private int ano;
    private String fabricante;


    public Carro(String modelo, int ano, String fabricante) {
        this.modelo = modelo;
        this.ano = ano;
        this.fabricante = fabricante;
    }


    public void acelerar() {
        System.out.println(modelo + " está pegando velocidade.");
    }

    public void abastecer() {
        System.out.println(modelo + " ficou com o tanque cheio.");
    }

    public void frear() {
        System.out.println(modelo + " está freando.");
    }
}
