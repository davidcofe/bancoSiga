package co.edu.unisabana.siga.banco.logica;

import co.edu.unisabana.siga.banco.bd.Cliente;
import co.edu.unisabana.siga.banco.bd.ClienteRepository;
import co.edu.unisabana.siga.banco.controller.dto.ClienteDTO;
import co.edu.unisabana.siga.banco.helper.Token;
import org.springframework.stereotype.Service;
import lombok.Lombok;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClienteLogica {

    private ClienteRepository clienteRepository;

    public ClienteLogica(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void guardarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setCodigo(clienteDTO.getCodigo());
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setApellido(clienteDTO.getApellido());
        cliente.setToken(Token.generateToken());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setHashedPassword((clienteDTO.getHashedPassword()));


        cliente.setFechaCreacion(LocalDate.now());
        cliente.setFechaModificacion(LocalDate.now());

        clienteRepository.save(cliente);
    }

    public List<Cliente> verCliente(int id) {
        return clienteRepository.getAccountById(id);
    }

}