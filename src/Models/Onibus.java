package Models;

import lombok.Data;

@Data
public class Onibus extends Veiculo{
    private String motor;
    private String placa;
    private Integer qtdPassageiros;

    public Onibus(double valorDeCompra, String motor, String placa, Integer qtdPassageiros){
        super(valorDeCompra);

        this.motor = motor;
        this.placa = placa;
        this.qtdPassageiros = qtdPassageiros;
    }

    @Override
    public double calcularDiaria() throws Exception {
        if(this.getValorDeCompra() >= 0 & getQtdPassageiros() >= 0)
            return (0.04 * this.getValorDeCompra()) + (100 * this.getQtdPassageiros());

        throw new Exception("Não foi possível calcular a diaria, o valor informado é inválido.");
    }

    @Override
    public String toString(){
        return "Onibus: $" + this.getId() + " - " + this.getValorDeCompra() + ", " + this.getQtdPassageiros()+ ", " +
                this.getMotor() + ", " + this.getPlaca();
    }
}
