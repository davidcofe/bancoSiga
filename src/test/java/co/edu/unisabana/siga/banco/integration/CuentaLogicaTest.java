package co.edu.unisabana.siga.banco.integration;

import co.edu.unisabana.siga.banco.bd.Cuenta;
import co.edu.unisabana.siga.banco.bd.CuentaRepository;
import co.edu.unisabana.siga.banco.controller.dto.CuentaDTO;
import co.edu.unisabana.siga.banco.helper.TipoCuenta;
import co.edu.unisabana.siga.banco.logica.CuentaLogica;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CuentaLogicaTest {

    @Mock
    CuentaRepository cuentaRepository;

    @InjectMocks
    CuentaLogica cuentaLogica;

    // crearCuenta
    @Test void Given_saldo_null_When_crearCuenta_Then_saldo_0() {
        CuentaDTO dto = new CuentaDTO(1101, "Test", TipoCuenta.AHORROS);

        Cuenta cuenta = cuentaLogica.crearCuenta(dto);
        Mockito.verify(cuentaRepository).save(cuenta);
        assertEquals(BigDecimal.valueOf(0.0), cuenta.getSaldo());
    }
    @Test void Given_saldo_x_When_crearCuenta_Then_saldo_x() {
        CuentaDTO dto = new CuentaDTO(1101, "Test", TipoCuenta.AHORROS);
        dto.setSaldo(BigDecimal.valueOf(10));

        Cuenta cuenta = cuentaLogica.crearCuenta(dto);
        Mockito.verify(cuentaRepository).save(cuenta);
        assertEquals(BigDecimal.valueOf(10), cuenta.getSaldo());
    }

    // verSaldoAhorros
    @Test void Given_saldo_null_When_verSaldoAhorros_Then_saldo_0() {
        Mockito.when(cuentaLogica.verSaldoAhorros(1101)).thenReturn(null);
        BigDecimal saldo = cuentaLogica.verSaldoAhorros(1101);

        Mockito.verify(cuentaRepository).getBalanceAhorros(1101);
        assertEquals(BigDecimal.valueOf(0.0), saldo);
    }
    @Test void Given_saldo_x_When_verSaldoAhorros_Then_saldo_x(){
        Mockito.when(cuentaLogica.verSaldoAhorros(1101)).thenReturn(BigDecimal.valueOf(10.0));
        BigDecimal saldo = cuentaLogica.verSaldoAhorros(1101);

        Mockito.verify(cuentaRepository).getBalanceAhorros(1101);
        assertEquals(BigDecimal.valueOf(10.0), saldo);
    }

    // verSaldoCorriente
    @Test void Given_saldo_null_When_verSaldoCorriente_Then_saldo_0() {
        Mockito.when(cuentaLogica.verSaldoCorriente(1101)).thenReturn(null);
        BigDecimal saldo = cuentaLogica.verSaldoCorriente(1101);

        Mockito.verify(cuentaRepository).getBalanceCorriente(1101);
        assertEquals(BigDecimal.valueOf(0.0), saldo);
    }
    @Test void Given_saldo_x_When_verSaldoCorriente_Then_saldo_x() {
        Mockito.when(cuentaLogica.verSaldoCorriente(1101)).thenReturn(BigDecimal.valueOf(10.0));
        BigDecimal saldo = cuentaLogica.verSaldoCorriente(1101);

        Mockito.verify(cuentaRepository).getBalanceCorriente(1101);
        assertEquals(BigDecimal.valueOf(10.0), saldo);
    }

    // verGastosTarjeta
    @Test void Given_saldo_null_When_verGastosTarjeta_Then_saldo_0() {
        Mockito.when(cuentaLogica.verGastosTarjeta(1101)).thenReturn(null);
        BigDecimal saldo = cuentaLogica.verGastosTarjeta(1101);

        Mockito.verify(cuentaRepository).getBalanceCredito(1101);
        assertEquals(BigDecimal.valueOf(0.0), saldo);
    }
    @Test void Given_saldo_x_When_verGastosTarjeta_Then_saldo_x() {
        Mockito.when(cuentaLogica.verGastosTarjeta(1101)).thenReturn(BigDecimal.valueOf(10.0));
        BigDecimal saldo = cuentaLogica.verGastosTarjeta(1101);

        Mockito.verify(cuentaRepository).getBalanceCredito(1101);
        assertEquals(BigDecimal.valueOf(10.0), saldo);
    }
}