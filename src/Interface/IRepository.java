package Interface;

import Models.Veiculo;

import java.util.List;
import java.util.UUID;

public interface IRepository {
    void adicionar(Veiculo veiculo) throws Exception;
    Veiculo listarPorId(UUID id) throws Exception;
    double obterValorDaDiariaPeloID(UUID id) throws Exception;
    Integer obterQuantidadeDeVeiculosCadastrados() throws Exception;
    Veiculo obterVeiculoComDiariaMaisCara() throws Exception;
    List<Veiculo> obterVeiculoPorTipo(Class<? extends Veiculo> tipoVeiculo) throws Exception;
    boolean remove(UUID id) throws Exception;
}
