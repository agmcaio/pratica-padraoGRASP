package Models;

import lombok.Data;

import java.util.UUID;


@Data
public abstract class Veiculo {
    private UUID id;
    private double valorDeCompra;

    public Veiculo (){
        this.id = UUID.randomUUID();
    }

    public Veiculo (double valorDeCompra) {
        this.id = UUID.randomUUID();
        this.valorDeCompra =  valorDeCompra;
    }

    public abstract double calcularDiaria() throws Exception;
}
