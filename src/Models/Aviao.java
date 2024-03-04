package Models;

import lombok.Data;

@Data
public class Aviao extends Veiculo {
    private double tempoVoo;
    private double velocidadeCruzeiro;

    public Aviao(double valorCompra, double tempoVoo, double velocidadeCruzeiro) {
        super(valorCompra);
        this.tempoVoo = tempoVoo;
        this.velocidadeCruzeiro = velocidadeCruzeiro;
    }

    @Override
    public double calcularDiaria() throws Exception{
        if (this.getValorDeCompra() >= 0 & this.getVelocidadeCruzeiro() >= 0)
            return (0.2 * getValorDeCompra()) + (1000 * getVelocidadeCruzeiro());
        throw new Exception("Não foi possível calcular a diaria, o valor informado é inválido.");
    }

    @Override
    public String toString(){
        return "Avião: $" + this.getId() + " - " + this.getValorDeCompra() + ", " + this.getTempoVoo() + "Hrs, " + this.getVelocidadeCruzeiro() + "KM";
    }
}
