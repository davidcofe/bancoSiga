package co.edu.unisabana.siga.banco.integration;

import co.edu.unisabana.siga.banco.bd.Cliente;
import co.edu.unisabana.siga.banco.controller.dto.ClienteDTO;
import co.edu.unisabana.siga.banco.controller.dto.CuentaDTO;
import co.edu.unisabana.siga.banco.controller.dto.RespuestaDTO;
import co.edu.unisabana.siga.banco.helper.TipoCuenta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ClienteControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test void crearCliente(){
        ClienteDTO dto = new ClienteDTO("Test", "Test", "Test@Email.com");

        ResponseEntity<RespuestaDTO> respuesta =
            restTemplate.postForEntity("/cliente/agregar", dto, RespuestaDTO.class);

        Assertions.assertEquals("cliente guardado correctamente", respuesta.getBody().getMensaje());
    }
}
