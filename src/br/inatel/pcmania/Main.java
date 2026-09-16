package br.inatel.pcmania;

import java.util.Scanner;

import br.inatel.pcmania.cliente.Cliente;
import br.inatel.pcmania.computador.Computador;
import br.inatel.pcmania.computador.MemoriaUSB;
import br.inatel.pcmania.pedido.ProcessarPedido;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int matricula = 188;
        Cliente cliente = new Cliente("Marcela Coelho", "000.000.000-00"); // chamando construtor

        // variáveis locais do metodo main, nao atributo
        int opcao = -1;
        int quantidadeComprada = 0;

        while (opcao != 0) {
            System.out.println("Qual promocao deseja comprar?");
            System.out.println("1 - Promocao 1");
            System.out.println("2 - Promocao 2");
            System.out.println("3 - Promocao 3");
            System.out.println("0 - Finalizar compra");
            opcao = entrada.nextInt();

            if (opcao == 0) { // um cliente deve comprar  dois ou mais computadores (2..*)
                if (quantidadeComprada < 2) {
                    System.out.println("O cliente deve comprar pelo menos 2 computadores.");
                    opcao = -1;
                }
            } else {
                Computador pcComprado = null; // nao existe objeto ainda, apenas:
                // uma variável capaz de guardar uma referência para um Computador *

                switch (opcao) {
                    case 1:
                        // chamando construtor
                        pcComprado = new Computador("Apple", matricula, //aqui sim cria a instância/objeto *
                                // "Apple" é o valor enviado para o parâmetro marca do construtor
                                // o construtor de 'Computador' é chamado
                                // 'pcComprado' é uma variável de referência do tipo Computador
                                // que guarda a referência dessa instância \/
                                // e referencia a instância criada com 'new Computador(...)'
                                "Pentium Core i5", 2200, 8, 500,
                                "macOS Sequoia", 64);
                        pcComprado.addMemoriaUSB(new MemoriaUSB("Pen-drive", 16)); // agregação
                        // AGREGACAO: Computador recebe a referência para uma MemoriaUSB,
                        // e não é responsável por construir internamente essa memória
                        // (essa memória pode existir independentemente do computador)
                        // o metodo addMemoriaUSB recebe esse objeto e guarda sua referencia
                        break;

                    case 2:
                        pcComprado = new Computador("Samsung", matricula + 1,
                                "Pentium Core i7", 3370, 16, 1000,
                                "Windows 8", 64);
                        pcComprado.addMemoriaUSB(new MemoriaUSB("Pen-drive", 32));
                        break;

                    case 3:
                        pcComprado = new Computador("Dell", matricula + 2,
                                // Cliente-Computador NAO eh composicao, pois
                                // Computador consegue existir sem um determinado Cliente
                                // o PC eh criado primeiro
                                // e só depois sua referência é adicionada ao cliente em
                                // 'cliente.getComputadores()[quantidadeComprada] = pcComprado;'
                                "Pentium Core i7", 4500, 32, 2000,
                                "Windows 10", 64);
                        pcComprado.addMemoriaUSB(new MemoriaUSB("HD Externo", 1000));
                        break;

                    default:
                        System.out.println("Opcao invalida.");
                        break;
                }

                if (pcComprado != null) { //computador pode ter nenhuma ou uma MemoriaUSB (0..1)
                    // se tiver memoria USB, mostra
                    // se não tiver, nao tenta acessa-la
                    cliente.getComputadores()[quantidadeComprada] = pcComprado; // associacao Cliente e Computador
                    // a referencia para o 'Computador' comprado é colocada no array do cliente
                    // logo, o Cliente conhece os computadores comprados através de
                    // um array de referências para Computador
                    quantidadeComprada++;
                    System.out.println("Computador adicionado a compra.\n");
                }
            }
        }

        System.out.println("\n--- DADOS DO CLIENTE ---");
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());

        System.out.println("\n--- COMPUTADORES COMPRADOS ---");
        for (Computador computador : cliente.getComputadores()) {
            if (computador != null) {
                computador.mostraPCConfigs();
            }
        }

        System.out.println("Total da compra: R$" + cliente.calculaTotalCompra());

        ProcessarPedido.processarPedido(cliente.getComputadores());
        // como o metodo 'processarPedido' é estatico, nao precisamos criar um objeto/instancia
        // ex: 'ProcessarPedido pedido = new ProcessarPedido();
        //pedido.processarPedido(...);'

        entrada.close();
    }
}
