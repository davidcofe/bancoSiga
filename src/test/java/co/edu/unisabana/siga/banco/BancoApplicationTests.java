package co.edu.unisabana.siga.banco;

import co.edu.unisabana.siga.banco.bd.Cliente;
import co.edu.unisabana.siga.banco.bd.ClienteRepository;
import co.edu.unisabana.siga.banco.controller.dto.ClienteDTO;
import co.edu.unisabana.siga.banco.controller.dto.RespuestaDTO;
import co.edu.unisabana.siga.banco.logica.ClienteLogica;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest @Profile("test")
class BancoApplicationTests {

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
