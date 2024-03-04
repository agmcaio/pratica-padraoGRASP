package Repository;

import Interface.IRepository;
import Models.Veiculo;

import java.util.*;

public class Repository implements IRepository {
    List<Veiculo> veiculos = new ArrayList<Veiculo>();

    public void adicionar(Veiculo veiculo) throws Exception {
        try {
            veiculos.add(veiculo);
        } catch (Exception ex) {
            throw new Exception("Erro ao cadastrar veiculo: " + ex);
        }
    }

    public Veiculo listarPorId(UUID id) throws Exception{
        for(Veiculo veiculo : veiculos)
            if(veiculo.getId().equals(id))
                return veiculo;

        throw new Exception("Não foi possível encontrar veículo com o ID informado.");
    }

    public double obterValorDaDiariaPeloID(UUID id) throws Exception{
        try{
            var veiculo = listarPorId(id);
            return veiculo.calcularDiaria();
        } catch (Exception ex){
            throw new Exception("Erro ao obter valor da diária pelo id: " + ex);
        }
    }

    public Integer obterQuantidadeDeVeiculosCadastrados() throws Exception{
        try{
            return veiculos.size();
        } catch (Exception ex) {
            throw new Exception("Erro ao obter quantidade de veiculos cadastrados: " + ex);
        }
    }

    public Veiculo obterVeiculoComDiariaMaisCara() throws Exception{
        double maiorDiaria = 0;
        Veiculo veiculoComMaiorDiaria = null;

        for(Veiculo veiculo : veiculos)
            if(veiculo.calcularDiaria() > maiorDiaria){
                maiorDiaria = veiculo.calcularDiaria();
                veiculoComMaiorDiaria = veiculo;
            }

        return veiculoComMaiorDiaria;
    }

    public List<Veiculo> obterVeiculoPorTipo(Class<? extends Veiculo> tipoVeiculo) throws Exception{
        try{
            List<Veiculo> veiculosPorTipo = new ArrayList<>();

            for (Veiculo veiculo : veiculos) {
                if (tipoVeiculo.isInstance(veiculo)) {
                    veiculosPorTipo.add(veiculo);
                }
            }
            veiculosPorTipo.sort(Comparator.comparing(Veiculo::getId));

            return veiculosPorTipo;
        } catch (Exception ex){
            throw new Exception("Erro ao obter veiculos por tipo: " + ex);
        }
    }

    public boolean remove(UUID id) throws Exception{
        var veiculo = listarPorId(id);
        return veiculos.remove(veiculo);
    }
}
