package co.edu.unisabana.siga.banco.integration;

import co.edu.unisabana.siga.banco.controller.dto.ClienteDTO;
import co.edu.unisabana.siga.banco.controller.dto.RespuestaDTO;
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
class TransaccionesControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;



    @Test void depositarFallo(){

        ResponseEntity<RespuestaDTO> respuesta =
                restTemplate.postForEntity("/depositar?numero_cuenta=9000&deposito=.", "", RespuestaDTO.class);

        Assertions.assertEquals(null, respuesta.getBody().getMensaje());
    }

    @Test void retirarFallo(){

        ResponseEntity<RespuestaDTO> respuesta =
                restTemplate.postForEntity("/retirar?numero_cuenta=9000&deposito=.", "", RespuestaDTO.class);

        Assertions.assertEquals(null, respuesta.getBody().getMensaje());
    }

    @Test void pagarFallo(){

        ResponseEntity<RespuestaDTO> respuesta =
                restTemplate.postForEntity("/pagar?numero_cuenta=9000&deposito=a", "", RespuestaDTO.class);

        Assertions.assertEquals(null, respuesta.getBody().getMensaje());
    }

    @Test void transferirFallo(){

        ResponseEntity<RespuestaDTO> respuesta =
                restTemplate.postForEntity("/transferir?numero_cuentaDe=9000&numero_cuentaHacia=60000&deposito=a", "", RespuestaDTO.class);

        Assertions.assertEquals(null, respuesta.getBody().getMensaje());
    }
}
