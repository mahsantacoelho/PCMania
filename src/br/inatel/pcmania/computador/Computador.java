package br.inatel.pcmania.computador;

public class Computador { // classe
    private String marca; //atributo, pertencem ao objeto/classe // encapsulamento
    private float preco; // encapsulamento
    // preço vem da promoção e é inicializado no construtor, não necessario alterar (setters)
    private HardwareBasico[] hardwaresBasicos; // composicao. Computador possui objeto HardwareBasico
    // HardwareBasico é uma Array pois o * significa que existem vários HardwareBasico
    private SistemaOperacional sistemaOperacional; // composicao. Computador possui objeto SistemaOperacional
    private MemoriaUSB memoriaUSB; // agregação, 'memória' existe independentemente

    public Computador(String marca, float preco, String processador, float mhz,
                      float memoriaRam, float hd, String nomeSistema, int tipoSistema) {  // construtor
        this.marca = marca;
        this.preco = preco;
        // 'this.preco' é o atributo do objeto atual; 'preco é o parâmetro recebido pelo construto

        // chamando construtor
        hardwaresBasicos = new HardwareBasico[3];//composicao*Computador cria e possiu essas partes no seu construtor
        // criado três posições capazes de guardar referências para HardwareBasico [null]
        hardwaresBasicos[0] = new HardwareBasico(processador, mhz);
        hardwaresBasicos[1] = new HardwareBasico("Memoria RAM", memoriaRam);
        hardwaresBasicos[2] = new HardwareBasico("HD", hd);
        // HardwareBasico é uma Array, logo, guarda referências para objetos, e não os objetos diretamente
        // cada "new HardwareBasico(...)" cria um objeto;
        // suas referências são guardadas nas posições 0, 1 e 2 do array

        // chamando construtor
        sistemaOperacional = new SistemaOperacional(nomeSistema, tipoSistema);// composicao *
        // o computador é o objeto_todo e esses objetos são as partes.
    }

    public void addMemoriaUSB(MemoriaUSB musb) {
        memoriaUSB = musb;
    } // } // metodo utilizado na agregação entre Computador e MemoriaUSB
    // so receber MemoriaUSB como parametro, nao necessariamente é uma agregação (seria dependencia?)
    // nesse caso é agregação pois Computador também possui um atributo 'MemoriaUSB memoriaUSB'
    // e guarda a referência recebida
    // 'memoriaUSB = musb;' não está "copiando toda a memória USB";
    // está fazendo as duas referências apontarem para o mesmo objeto

    public void mostraPCConfigs() { // metodo
        System.out.println("Marca: " + marca);
        System.out.println("Preco: R$" + preco);
        System.out.println(hardwaresBasicos[0].getNome() + " (" + hardwaresBasicos[0].getCapacidade() + " Mhz)");
        System.out.println(hardwaresBasicos[1].getCapacidade() + " Gb de " + hardwaresBasicos[1].getNome());
        System.out.println(hardwaresBasicos[2].getCapacidade() + " Gb de " + hardwaresBasicos[2].getNome());
        System.out.println("Sistema Operacional: " + sistemaOperacional.getNome() + " (" + sistemaOperacional.getTipo() + " bits)");

        if (memoriaUSB != null) {
            System.out.println("Acompanha: " + memoriaUSB.getNome() + " de " + memoriaUSB.getCapacidade() + " Gb");
        }

        System.out.println();
    }

    public float getPreco() {
        return preco;
    }
}
