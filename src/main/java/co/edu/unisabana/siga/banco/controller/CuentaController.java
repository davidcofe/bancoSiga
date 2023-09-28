package co.edu.unisabana.siga.banco.controller;

import co.edu.unisabana.siga.banco.bd.Cuenta;
import co.edu.unisabana.siga.banco.controller.dto.CuentaDTO;
import co.edu.unisabana.siga.banco.controller.dto.RespuestaDTO;
import co.edu.unisabana.siga.banco.logica.CuentaLogica;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CuentaController {

    private CuentaLogica logica;

    public CuentaController(CuentaLogica logica) {
        this.logica = logica;
    }


    @PostMapping(path = "/cuenta/crear")
    @Operation(summary = "Deja crear nueva cuenta", description = "Se crea una cuenta nueva exitosamente")
    @ApiResponse(responseCode = "200", description = "Se creo cuenta")
    @ApiResponse(responseCode = "400", description = "No se pudo crear la cuenta")
    @ApiResponse(responseCode = "404", description = "Cuenta invalida")

    public RespuestaDTO crearCuenta(@RequestBody CuentaDTO cuentaDTO) {
        try {
            logica.crearCuenta(cuentaDTO);

            return new RespuestaDTO("Cuenta guardada correctamente");
        } catch (IllegalArgumentException e) {
            return new RespuestaDTO("Cuenta con nombre prohibido");
        }
    }

    @GetMapping(path = "/cuenta/{id}")
    @Operation(summary = "Deja buscar una cuenta mediante el ID", description = "Se devuelve la cuenta buscada")
    @ApiResponse(responseCode = "200", description = "Se encontro cuenta de usuario")
    @ApiResponse(responseCode = "400", description = "Usuario invalido para cuenta")
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")

    public List<Cuenta> verCuenta(@PathVariable int id) {
        try{
            return logica.verCuenta(id);
        } catch (IllegalArgumentException e) {
            return (List<Cuenta>) e;
        }
    }

    @GetMapping(path = "/cuenta/{id}/saldo")
    @Operation(summary = "Deja ver el saldo de una cuenta espedifica", description = "Retorna el saldo de la cuenta solicitada")
    @ApiResponse(responseCode = "200", description = "Se encontro saldo de usuario")
    @ApiResponse(responseCode = "400", description = "Usuario invalido para buscar saldo")
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")

    public String verSaldo(@PathVariable int id) {
        try {
            return "Saldo Total: " + logica.verSaldo(id).toString() + "\n" +
                   "Saldo Ahorros: " + logica.verSaldoAhorros(id).toString() + "\n" +
                   "Saldo Corriente: " + logica.verSaldoCorriente(id).toString() + "\n" +
                   "Gastos con Tarjeta: " + logica.verGastosTarjeta(id).toString();
        } catch (IllegalArgumentException e) {
            return "No se visualizo el saldo";
        }
    }
}