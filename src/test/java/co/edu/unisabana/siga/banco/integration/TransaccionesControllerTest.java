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
public class TransaccionesControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test public void depositar(){

        ResponseEntity<RespuestaDTO> respuesta =
                restTemplate.postForEntity("/depositar?numero_cuenta=9000&deposito=1", "", RespuestaDTO.class);

        Assertions.assertEquals("DEPOSITO exitoso", respuesta.getBody().getMensaje());
    }

    @Test public void retirar(){

        ResponseEntity<RespuestaDTO> respuesta =
                restTemplate.postForEntity("/retirar?numero_cuenta=9000&deposito=1", "", RespuestaDTO.class);

        Assertions.assertEquals("RETIRO exitoso", respuesta.getBody().getMensaje());
    }

    @Test public void pagar(){

        ResponseEntity<RespuestaDTO> respuesta =
                restTemplate.postForEntity("/pagar?numero_cuenta=9000&deposito=1000", "", RespuestaDTO.class);

        Assertions.assertEquals("PAGO exitoso", respuesta.getBody().getMensaje());
    }

    @Test public void transferir(){

        ResponseEntity<RespuestaDTO> respuesta =
                restTemplate.postForEntity("/transferir?numero_cuentaDe=9000&numero_cuentaHacia=60000&deposito=1000", "", RespuestaDTO.class);

        Assertions.assertEquals("TRANSFERENCIA exitosa", respuesta.getBody().getMensaje());
    }

    @Test public void depositarFallo(){

        ResponseEntity<RespuestaDTO> respuesta =
                restTemplate.postForEntity("/depositar?numero_cuenta=9000&deposito=.", "", RespuestaDTO.class);

        Assertions.assertEquals(null, respuesta.getBody().getMensaje());
    }

    @Test public void retirarFallo(){

        ResponseEntity<RespuestaDTO> respuesta =
                restTemplate.postForEntity("/retirar?numero_cuenta=9000&deposito=.", "", RespuestaDTO.class);

        Assertions.assertEquals(null, respuesta.getBody().getMensaje());
    }

    @Test public void pagarFallo(){

        ResponseEntity<RespuestaDTO> respuesta =
                restTemplate.postForEntity("/pagar?numero_cuenta=9000&deposito=a", "", RespuestaDTO.class);

        Assertions.assertEquals(null, respuesta.getBody().getMensaje());
    }

    @Test public void transferirFallo(){

        ResponseEntity<RespuestaDTO> respuesta =
                restTemplate.postForEntity("/transferir?numero_cuentaDe=9000&numero_cuentaHacia=60000&deposito=a", "", RespuestaDTO.class);

        Assertions.assertEquals(null, respuesta.getBody().getMensaje());
    }
}
