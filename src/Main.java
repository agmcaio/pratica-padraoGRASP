import Interface.ESistemaDePartida;
import Models.*;
import Repository.Repository;

public class Main {
    public static void main(String[] args) throws Exception{
        var veiculos = new Repository();

        var aviao = new Aviao(900000, 4, 850);
        System.out.println("Valor da diaria do avião: " + aviao.calcularDiaria());
        var aviaoId = aviao.getId();

        var aviao2 = new Aviao(800000, 3, 700);
        System.out.println("Valor da diaria do avião 2: " + aviao2.calcularDiaria());
        var aviao2Id = aviao2.getId();

        var carro = new Carro(80000, 800, "V8", "TAL987");
        System.out.println("Valor da diaria do carro: " + carro.calcularDiaria());
        var carroId = carro.getId();

        var helicoptero = new Helicoptero(900000, 2, 2);
        System.out.println("Valor da diaria do helicoptero: " + helicoptero.calcularDiaria());
        var helicopteroId = helicoptero.getId();

        var moto = new Moto(40000, "500", "MYM0120", ESistemaDePartida.eletrico);
        System.out.println("Valor da diaria da Moto: " + moto.calcularDiaria());
        var motoId = moto.getId();

        var onibus = new Onibus(500000, "MB OM 926 LA", "TAL123", 50);
        System.out.println("Valor da diaria do onibus: " + onibus.calcularDiaria());
        var onibusId = onibus.getId();

        System.out.println("\n");
        System.out.println("Cadastrando veiculos...");
        veiculos.adicionar(aviao);
        veiculos.adicionar(aviao2);
        veiculos.adicionar(carro);
        veiculos.adicionar(helicoptero);
        veiculos.adicionar(moto);
        veiculos.adicionar(onibus);
        System.out.println("Veiculos cadastrados com sucesso!");

        System.out.println("\n");
        System.out.println("Lista de veículos cadastrados:");
        System.out.println(veiculos.listarPorId(aviaoId));
        System.out.println(veiculos.listarPorId(aviao2Id));
        System.out.println(veiculos.listarPorId(carroId));
        System.out.println(veiculos.listarPorId(helicopteroId));
        System.out.println(veiculos.listarPorId(motoId));
        System.out.println(veiculos.listarPorId(onibusId));

        System.out.println("\n");
        System.out.println("Valores diarios de cada veiculo cadastrado:");
        System.out.println("Valor diário do avião: " + veiculos.obterValorDaDiariaPeloID(aviaoId));
        System.out.println("Valor diário do avião 2: " + veiculos.obterValorDaDiariaPeloID(aviao2Id));
        System.out.println("Valor diário do carro: " + veiculos.obterValorDaDiariaPeloID(carroId));
        System.out.println("Valor diário do moto: " + veiculos.obterValorDaDiariaPeloID(motoId));
        System.out.println("Valor diário do helicoptero: " + veiculos.obterValorDaDiariaPeloID(helicopteroId));
        System.out.println("Valor diário do onibus: " + veiculos.obterValorDaDiariaPeloID(onibusId));

        System.out.println("\n");
        System.out.println("Quantidade de veiculos cadastrados: " + veiculos.obterQuantidadeDeVeiculosCadastrados());

        System.out.println("\n");
        System.out.println("Veiculo com diaria mais cara: " + veiculos.obterVeiculoComDiariaMaisCara());

        System.out.println("\n");
        System.out.println("Veiculo por tipo e ordenado por id: ");
        for (var veiculo : veiculos.obterVeiculoPorTipo(Aviao.class)){
            System.out.println(veiculo);
        }
    }
}