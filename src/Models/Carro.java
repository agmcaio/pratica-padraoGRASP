package Models;

import lombok.Data;

@Data
public class Carro extends Veiculo {
    private double autonomia;
    private String motor;
    private String placa;

    public Carro(double valorDeCompra, double autonomia, String motor, String placa) {
        super(valorDeCompra);
        this.autonomia = autonomia;
        this.motor = motor;
        this.placa = placa;
    }

    @Override
    public double calcularDiaria() throws Exception{
        if(this.getValorDeCompra() >= 0)
            return 0.02 * this.getValorDeCompra();

        throw new Exception("Não foi possível calcular a diaria, o valor informado é inválido.");
    }

    @Override
    public String toString(){
        return "Carro: $" + this.getId() + " - " + this.getValorDeCompra() + ", " + this.getAutonomia() + "KM, " +
                this.getMotor() + ", " + this.getPlaca();
    }
}
