package br.inatel.pcmania.computador;

public class HardwareBasico {
    private String nome;
    private float capacidade;

    public HardwareBasico(String nome, float capacidade) { // construtor
        this.nome = nome;
        this.capacidade = capacidade;
    }

    // getters para o Computador acessar o Nome e a Capacidade,
    // que são privados, para mostrar as configurações.
    // Não criado setters pois depois de criar aquele hardware,
    // não existe necessidade de modificar Nome ou Capacidade

    public String getNome() {
        return nome;
    }

    public float getCapacidade() {
        return capacidade;
    }
}
