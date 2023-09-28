package co.edu.unisabana.siga.banco.controller;

import co.edu.unisabana.siga.banco.bd.CuentaRepository;
import co.edu.unisabana.siga.banco.controller.dto.RespuestaDTO;
import co.edu.unisabana.siga.banco.logica.HistorialLogica;
import co.edu.unisabana.siga.banco.logica.TransaccionLogica;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.jetbrains.annotations.Contract;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransaccionesController {
    private TransaccionLogica logica;

    public TransaccionesController(TransaccionLogica logica) {
        this.logica = logica;
    }

    @PostMapping(path = "/depositar")
    @Operation(summary = "Deja depositar dinero", description = "Se deposita dinero exitosamente")
    @ApiResponse(responseCode = "200", description = "Dinero depositado")
    @ApiResponse(responseCode = "400", description = "Cantidad Invalida de deposito")
    @ApiResponse(responseCode = "404", description = "No se encontro deposito")

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
    @Operation(summary = "Deja retirar dinero", description = "Se retirar dinero exitosamente")
    @ApiResponse(responseCode = "200", description = "Dinero retirado")
    @ApiResponse(responseCode = "400", description = "Cantidad Invalida Dinero para retirar")
    @ApiResponse(responseCode = "404", description = "No se encontro Retiro")

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
    @Operation(summary = "Deja pagar cuentas con dinero", description = "Se paga la transaccion exitosamente")
    @ApiResponse(responseCode = "200", description = "Dinero usado para pagar")
    @ApiResponse(responseCode = "400", description = "Cantidad Invalida Dinero para pagar")
    @ApiResponse(responseCode = "404", description = "No se encontro Pago")

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
    @Operation(summary = "Deja transferir dinero", description = "Se transfiere dinero exitosamente")
    @ApiResponse(responseCode = "200", description = "Dinero Transferido")
    @ApiResponse(responseCode = "400", description = "Cantidad Invalida Dinero")
    @ApiResponse(responseCode = "404", description = "No se encontro transferencia")

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
