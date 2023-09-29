package co.edu.unisabana.siga.banco.controller.dto;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter @Setter
public class HistorialDTO {

    private int codigoTransaccion;
    private int numeroCuenta;
    private String tipoTransaccion;
    private BigDecimal saldo;

    public HistorialDTO(int numeroCuenta, String tipoTransaccion, BigDecimal saldo) {
        this.numeroCuenta = numeroCuenta;
        this.tipoTransaccion = tipoTransaccion;
        this.saldo = saldo;
    }
}
