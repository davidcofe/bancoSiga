package co.edu.unisabana.siga.banco.controller;

import co.edu.unisabana.siga.banco.bd.Cliente;
import co.edu.unisabana.siga.banco.bd.Cuenta;
import co.edu.unisabana.siga.banco.controller.dto.ClienteDTO;
import co.edu.unisabana.siga.banco.controller.dto.RespuestaDTO;
import co.edu.unisabana.siga.banco.logica.ClienteLogica;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ClienteController {

    private ClienteLogica logica;

    public ClienteController(ClienteLogica logica) {
        this.logica = logica;
    }

    @PostMapping(path = "/cliente/agregar")
    @Operation(summary = "Deja agregar a nuevos clientes", description = "Se agrega el cliente si todo sale bien")
    @ApiResponse(responseCode = "200", description = "Se agrego cliente")
    @ApiResponse(responseCode = "400", description = "No se pudo agregar cliente")
    @ApiResponse(responseCode = "404", description = "Cliente no valido")

    public RespuestaDTO guardarCliente(@RequestBody ClienteDTO clienteDTO) {
        try {
            logica.guardarCliente(clienteDTO);
            log.info("se guardo un nuevo cliente " + clienteDTO.getNombre() + ":" + clienteDTO.getCodigo());
            return new RespuestaDTO("cliente guardado correctamente");
        } catch (IllegalArgumentException e) {
            return new RespuestaDTO("cliente con nombre prohibido");
        }
    }

    @GetMapping(path = "/cliente/{id}")
    @Operation(summary = "Deja buscar a un clientes por un ID dado", description = "Aparece la informacion del cliente buscado")
    @ApiResponse(responseCode = "200", description = "Se encontro Cliente")
    @ApiResponse(responseCode = "400", description = "Cliente invalido")
    @ApiResponse(responseCode = "404", description = "Cliente no encontrado")

    public List<Cliente> verCliente(@PathVariable int id) {
        try{

            return logica.verCliente(id);
        } catch (IllegalArgumentException e) {
            return (List<Cliente>) e;
        }
    }
}