package co.edu.unisabana.siga.banco.controller;

import co.edu.unisabana.siga.banco.bd.Historial;
import co.edu.unisabana.siga.banco.logica.HistorialLogica;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HistorialController {

    private HistorialLogica logica;

    public HistorialController(HistorialLogica logica) {
        this.logica = logica;
    }

    @GetMapping(path = "/historial/{cuenta}")
    @Operation(summary = "Deja ver el historial de la cuenta solicitada", description = "Se ve el historial exitosamente")
    @ApiResponse(responseCode = "200", description = "Se encontro historial de usuario")
    @ApiResponse(responseCode = "400", description = "Usuario invalido para historial")
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")

    public List<Historial> verHistorial(@PathVariable int cuenta) {
        try {
            return logica.verHistorial(cuenta);
        } catch (IllegalArgumentException e) {
            return (List<Historial>) e;
        }
    }
}
