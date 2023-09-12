package co.edu.unisabana.siga.banco.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class RespuestaDTO {

    String mensaje;

    public RespuestaDTO(String mensaje) {
        this.mensaje = mensaje;
    }
}
