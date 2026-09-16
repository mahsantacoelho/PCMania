package br.inatel.pcmania.pedido;

import br.inatel.pcmania.computador.Computador; // Permite utilizar classe de outro pacote

public class ProcessarPedido {
    // nao tem construtor declarado explicitamente pois é uma classe puramente utilitária
    // e não criamos uma instância dela

    public static void processarPedido(Computador[] computadores) {
        System.out.println("Pedido enviado...");
    }
    // metodo static -> nao depende de uma instancia e eh adequado para metodo utilitario/helper;
    // o qual nao guarda dados ou estados da classe (não usa variáveis de instância)
    // permite chama-lo diretamente pelo nome da classe sem precisar criar um objeto novo
    // 'static' pertence à classe
}
