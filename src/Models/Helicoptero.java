package Models;

import lombok.Data;

@Data
public class Helicoptero extends Veiculo{
    private Integer qtdRotores;
    private double tempoVoo;
    public Helicoptero(double valorDeCompra, Integer qtdRotores, double tempoVoo) {
        super(valorDeCompra);
        this.qtdRotores = qtdRotores;
        this.tempoVoo = tempoVoo;
    }

    @Override
    public double calcularDiaria() throws Exception{
        if(this.getValorDeCompra() >= 0 && this.getQtdRotores() > 0)
            return (0.1 * this.getValorDeCompra()) * this.getQtdRotores();

        throw new Exception("Não foi possível calcular a diaria, o valor informado é inválido.");
    }

    @Override
    public String toString(){
        return "Helicóptero: $" + this.getId() + " - " + this.getValorDeCompra() + ", " + this.getTempoVoo() + "Hrs, " +
                this.getQtdRotores();
    }
}
