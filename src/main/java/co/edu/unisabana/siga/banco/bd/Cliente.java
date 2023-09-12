package co.edu.unisabana.siga.banco.bd;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@Getter @Setter
public class Cliente {

    @Id
    @GeneratedValue
    @Column
    private int codigo;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private int saldo;
    @Column
    private LocalDate fechaCreacion;
    @Column
    private LocalDate fechaModificacion;
    @Column
    private String token;
    @Column
    private String email;
    @Column
    private String hashedPassword;
}