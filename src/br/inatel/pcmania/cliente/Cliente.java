package br.inatel.pcmania.cliente;

import br.inatel.pcmania.computador.Computador;

public class Cliente {
    private String nome; // encapsulamento, impede acesso direto de outras classes
    private String cpf; // encapsulamento
    private Computador[] computadores; // associacao // array
    // objeto Cliente mantem referencias para objetos Computador

    public Cliente(String nome, String cpf) { // construtor
        this.nome = nome;
        this.cpf = cpf;
        computadores = new Computador[100]; // até 100 apenas pra nao usar ArrayList
    }

    public float calculaTotalCompra() { // metodo
        float total = 0;

        for (Computador computador : computadores) { // for-each p/ percorrer a array
            // computador eh uma variavel de referencia do tipo Computador
            // A cada repeticao ela recebe a referencia armazenada em uma posição diferente do array
            if (computador != null) { // null pois '[100]' cria apenas posicoes vazias
                // se fizesse 'computador.getPreco();' -> quando 'computador == null',
                // estaria tentando chamar um metodo sem existir objeto naquela referência
                total = total + computador.getPreco();
            }
        }

        return total;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Computador[] getComputadores() {
        return computadores;
    }
}
