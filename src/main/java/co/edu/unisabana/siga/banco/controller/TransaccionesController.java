package co.edu.unisabana.siga.banco.controller;

import co.edu.unisabana.siga.banco.bd.CuentaRepository;
import co.edu.unisabana.siga.banco.controller.dto.RespuestaDTO;
import co.edu.unisabana.siga.banco.logica.HistorialLogica;
import co.edu.unisabana.siga.banco.logica.TransaccionLogica;
import org.jetbrains.annotations.Contract;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransaccionesController {
    private TransaccionLogica logica;

    public TransaccionesController(TransaccionLogica logica) {
        this.logica = logica;
    }

    @PostMapping(path = "/depositar")
    public RespuestaDTO depositar(@RequestParam("numero_cuenta") String numero_cuenta,
                                  @RequestParam("deposito") String deposito){
        try {
            logica.depositar(numero_cuenta, deposito);

            return new RespuestaDTO("DEPOSITO exitoso");
        } catch (IllegalArgumentException e) {
            return new RespuestaDTO("ERROR en el DEPOSITO");
        }
    }

    @PostMapping(path = "/retirar")
    public RespuestaDTO retirar(@RequestParam("numero_cuenta") String numero_cuenta,
                                @RequestParam("deposito") String deposito){
        try {
            logica.retirar(numero_cuenta, deposito);

            return new RespuestaDTO("RETIRO exitoso");
        } catch (IllegalArgumentException e) {
            return new RespuestaDTO("ERROR en el RETIRO");
        }
    }

    @PostMapping(path = "/pagar")
    public RespuestaDTO pagos(@RequestParam("numero_cuenta") String numero_cuenta,
                              @RequestParam("deposito") String deposito){
        try {
            logica.pagos(numero_cuenta, deposito);

            return new RespuestaDTO("PAGO exitoso");
        } catch (IllegalArgumentException e) {
            return new RespuestaDTO("ERROR en el PAGO");
        }
    }

    @PostMapping(path = "/transferir")
    public RespuestaDTO transferencias(@RequestParam("numero_cuentaDe") String numero_cuentaDe,
                                       @RequestParam("numero_cuentaHacia") String numero_cuentaHacia,
                                       @RequestParam("deposito") String deposito){
        try {
            logica.transferencias(numero_cuentaDe, numero_cuentaHacia, deposito);

            return new RespuestaDTO("TRANSFERENCIA exitosa");
        } catch (IllegalArgumentException e) {
            return new RespuestaDTO("ERROR en la TRANSFERENCIA");
        }
    }
}
