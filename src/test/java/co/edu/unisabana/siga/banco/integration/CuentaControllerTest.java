package co.edu.unisabana.siga.banco.integration;

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
public class CuentaControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test public void crearCuenta(){
        CuentaDTO dto = new CuentaDTO(0, "Test", TipoCuenta.Ahorros);

        ResponseEntity<RespuestaDTO> respuesta =
        restTemplate.postForEntity("/cuenta/crear", dto, RespuestaDTO.class);

        Assertions.assertEquals("Cuenta guardado correctamente", respuesta.getBody().getMensaje());
    }

    @Test public void verCuenta(){

    }
}
