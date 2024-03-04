package Models;

import Interface.ESistemaDePartida;
import lombok.Data;

@Data
public class Moto extends Veiculo{
    private String motor;
    private String placa;
    private ESistemaDePartida sistemaDePartida;

    public Moto(double valorDeCompra, String motor, String placa, ESistemaDePartida sistemaDePartida){
        super(valorDeCompra);
        this.motor = motor;
        this.placa = placa;
        this.sistemaDePartida = sistemaDePartida;
    }

    @Override
    public double calcularDiaria() throws Exception {

        if(this.getValorDeCompra() >= 0 & this.sistemaDePartida != null){
            var porcentagemValorDeCompra = 0.02 * this.getValorDeCompra();

            if(this.sistemaDePartida.equals(ESistemaDePartida.eletrico))
                return porcentagemValorDeCompra + 20;
            else if (this.sistemaDePartida.equals(ESistemaDePartida.manual)) {
                return porcentagemValorDeCompra + 5;
            }
        }

        throw new Exception("Não foi possível calcular a diaria, o valor informado é inválido.");
    }

    @Override
    public String toString(){
        return "Moto: $" + this.getId() + " - " + this.getValorDeCompra() + ", " + this.getSistemaDePartida() +
                ", " + this.getMotor() + ", " + this.getPlaca() + ", " + this.getSistemaDePartida();
    }
}
