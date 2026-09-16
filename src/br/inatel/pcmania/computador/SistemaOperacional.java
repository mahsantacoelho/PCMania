package br.inatel.pcmania.computador;

public class SistemaOperacional {
    private String nome;
    private int tipo;

    public SistemaOperacional(String nome, int tipo) { // construtor
        // (Para garantir que o objeto já seja criado com os atributos necessários inicializados)
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public int getTipo() {
        return tipo;
    }
}
