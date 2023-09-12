package co.edu.unisabana.siga.banco.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter @Setter
public class HistorialDTO {

    private int codigoTransaccion;
    private int numeroCuenta;
    private String tipoTransaccion;
    private BigDecimal saldo;
}
