package br.inatel.pcmania.computador;

public class MemoriaUSB { // MemoriaUSB vai ser criada fora do Computador e depois entregue ao computador
    private String nome;
    private int capacidade;

    public MemoriaUSB(String nome, int capacidade) { // construtor
        this.nome = nome;
        // 'this.nome' é o atributo do objeto atual
        // 'nome' é o parâmetro do construtor
        // logo: coloca no atributo 'nome' deste objeto o valor recebido no parâmetro 'nome'
        this.capacidade = capacidade;
    }

    public String getNome() {
        return nome;
    }

    public int getCapacidade() {
        return capacidade;
    }
}
