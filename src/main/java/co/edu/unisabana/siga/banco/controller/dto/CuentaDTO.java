package co.edu.unisabana.siga.banco.controller.dto;

import co.edu.unisabana.siga.banco.helper.TipoCuenta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter @Setter @AllArgsConstructor
public class CuentaDTO {

    private int idUsuario;
    private int numeroCuenta;
    private String nombreCuenta;
    private TipoCuenta tipoCuenta;
    private BigDecimal saldo;

    public CuentaDTO(int idUsuario, String nombreCuenta, TipoCuenta tipoCuenta){
        this.idUsuario = idUsuario;
        this.nombreCuenta = nombreCuenta;
        this.tipoCuenta = tipoCuenta;
    }
}
