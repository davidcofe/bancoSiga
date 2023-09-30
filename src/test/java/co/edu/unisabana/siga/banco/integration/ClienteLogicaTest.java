package co.edu.unisabana.siga.banco.integration;

import co.edu.unisabana.siga.banco.bd.Cliente;
import co.edu.unisabana.siga.banco.bd.ClienteRepository;
import co.edu.unisabana.siga.banco.controller.dto.ClienteDTO;
import co.edu.unisabana.siga.banco.logica.ClienteLogica;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ClienteLogicaTest {

    @Mock
    ClienteRepository clienteRepository;

    @InjectMocks
    ClienteLogica clienteLogica;

    @Test void Given_dto_When_guardarCliente_Then_successful(){
        ClienteDTO dto = new ClienteDTO("Test", "Test", "test@correo.com");

        Cliente cliente = clienteLogica.guardarCliente(dto);
        Mockito.verify(clienteRepository).save(cliente);
    }
}
