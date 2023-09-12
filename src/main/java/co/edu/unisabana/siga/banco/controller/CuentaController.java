package co.edu.unisabana.siga.banco.controller;

import co.edu.unisabana.siga.banco.bd.Cuenta;
import co.edu.unisabana.siga.banco.controller.dto.CuentaDTO;
import co.edu.unisabana.siga.banco.controller.dto.RespuestaDTO;
import co.edu.unisabana.siga.banco.logica.CuentaLogica;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CuentaController {

    private CuentaLogica logica;

    public CuentaController(CuentaLogica logica) {
        this.logica = logica;
    }


    @PostMapping(path = "/cuenta/crear")
    public RespuestaDTO crearCuenta(@RequestBody CuentaDTO cuentaDTO) {
        try {
            logica.crearCuenta(cuentaDTO);

            return new RespuestaDTO("Cuenta guardado correctamente");
        } catch (IllegalArgumentException e) {
            return new RespuestaDTO("Cuenta con nombre prohibido");
        }
    }

    @GetMapping(path = "/cuenta/{id}")
    public List<Cuenta> verCuenta(@PathVariable int id) {
        try{
            return logica.verCuenta(id);
        } catch (IllegalArgumentException e) {
            return (List<Cuenta>) e;
        }
    }

    @GetMapping(path = "/cuenta/{id}/saldo")
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