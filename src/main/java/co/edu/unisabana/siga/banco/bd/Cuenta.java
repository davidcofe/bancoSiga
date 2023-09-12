package co.edu.unisabana.siga.banco.bd;

import lombok.Getter;
import lombok.Setter;
import co.edu.unisabana.siga.banco.helper.TipoCuenta;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table
@Getter @Setter
public class Cuenta {

    @Id
    @Column
    private int numeroCuenta;
    @Column
    private int idUsuario;
    @Column
    private String nombreCuenta;
    @Column
    private TipoCuenta tipoCuenta;
    @Column
    private BigDecimal saldo;
    @Column
    private LocalDate fechaCreacion;
    @Column
    private LocalDate fechaModificacion;
}