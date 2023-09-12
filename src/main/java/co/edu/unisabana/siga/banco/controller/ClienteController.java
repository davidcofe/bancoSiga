package co.edu.unisabana.siga.banco.controller;

import co.edu.unisabana.siga.banco.bd.Cliente;
import co.edu.unisabana.siga.banco.bd.Cuenta;
import co.edu.unisabana.siga.banco.controller.dto.ClienteDTO;
import co.edu.unisabana.siga.banco.controller.dto.RespuestaDTO;
import co.edu.unisabana.siga.banco.logica.ClienteLogica;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    private ClienteLogica logica;

    public ClienteController(ClienteLogica logica) {
        this.logica = logica;
    }

    @PostMapping(path = "/cliente/agregar")
    public RespuestaDTO guardarCliente(@RequestBody ClienteDTO clienteDTO) {
        try {
            logica.guardarCliente(clienteDTO);
            return new RespuestaDTO("cliente guardado correctamente");
        } catch (IllegalArgumentException e) {
            return new RespuestaDTO("cliente con nombre prohibido");
        }
    }

    @GetMapping(path = "/cliente/{id}")
    public List<Cliente> verCliente(@PathVariable int id) {
        try{
            return logica.verCliente(id);
        } catch (IllegalArgumentException e) {
            return (List<Cliente>) e;
        }
    }
}