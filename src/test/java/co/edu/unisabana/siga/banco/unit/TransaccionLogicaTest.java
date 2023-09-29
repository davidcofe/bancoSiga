package co.edu.unisabana.siga.banco.unit;

import co.edu.unisabana.siga.banco.bd.CuentaRepository;
import co.edu.unisabana.siga.banco.bd.Historial;
import co.edu.unisabana.siga.banco.bd.HistorialRepository;
import co.edu.unisabana.siga.banco.controller.dto.HistorialDTO;
import co.edu.unisabana.siga.banco.logica.TransaccionLogica;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class TransaccionLogicaTest {

    @Mock
    CuentaRepository cuentaRepository;
    @Mock
    HistorialRepository historialRepository;

    @InjectMocks
    TransaccionLogica transaccionLogica;

    // depositar
    @Test void Given_id_deposito_When_depositar_Then_successful(){
        Mockito.when(cuentaRepository.getBalanceCuenta(1101)).thenReturn(10.0);

        transaccionLogica.depositar("1101", "50.0");
        Mockito.verify(cuentaRepository).getBalanceCuenta(1101);
        Mockito.verify(cuentaRepository).cambiarBalanceCuentaById(10.0 + 50.0, 1101);
    }

    // guardarMovimiento
    @Test void Given_dto_When_guardarMovimiento_Then_successful(){
        HistorialDTO dto = new HistorialDTO(1101, "DEPOSITO", BigDecimal.valueOf(10.0));

        Historial historial = transaccionLogica.guardarMovimiento(dto);
        Mockito.verify(historialRepository).save(historial);
        assertEquals(1101, historial.getNumeroCuenta());
        assertEquals(BigDecimal.valueOf(10.0), historial.getSaldo());
    }
}