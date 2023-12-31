package co.edu.unisabana.siga.banco.controller.dto;

import co.edu.unisabana.siga.banco.helper.TipoCuenta;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter @Setter
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
