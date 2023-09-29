package co.edu.unisabana.siga.banco.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ClienteDTO {
    private String nombre;
    private int codigo;
    private String apellido;
    private int saldo;
    private boolean cuentaAhorros;
    private boolean cuentaCorriente;
    private boolean tarjetaCredito;
    private String email;
    private String hashedPassword;

    public ClienteDTO(String nombre, String apellido, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }
}
