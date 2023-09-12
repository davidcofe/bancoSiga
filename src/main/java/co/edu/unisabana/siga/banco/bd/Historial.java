package co.edu.unisabana.siga.banco.bd;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table
@Getter @Setter
public class Historial {

    @Id
    @GeneratedValue
    @Column
    private int codigoTransaccion;
    @Column
    private int numeroCuenta;
    @Column
    private String tipoTransaccion;
    @Column
    private BigDecimal saldo;
    @Column
    private LocalDate fechaCreacion;
}