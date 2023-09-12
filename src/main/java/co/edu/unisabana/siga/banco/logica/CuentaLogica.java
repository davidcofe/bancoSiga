package co.edu.unisabana.siga.banco.logica;

import co.edu.unisabana.siga.banco.bd.Cuenta;
import co.edu.unisabana.siga.banco.bd.CuentaRepository;
import co.edu.unisabana.siga.banco.controller.dto.CuentaDTO;
import co.edu.unisabana.siga.banco.helper.GeneradorCuenta;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class CuentaLogica {

    private CuentaRepository cuentaRepository;

    public CuentaLogica(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    public void crearCuenta(CuentaDTO cuentaDTO) {
        Cuenta cuenta = new Cuenta();
        cuenta.setIdUsuario(cuentaDTO.getIdUsuario());
        cuenta.setNombreCuenta(cuentaDTO.getNombreCuenta());
        cuenta.setTipoCuenta(cuentaDTO.getTipoCuenta());

        if(cuentaDTO.getSaldo()==null){
            cuenta.setSaldo(BigDecimal.valueOf(0.0));
        } else {
            cuenta.setSaldo(cuentaDTO.getSaldo());
        }
        cuenta.setNumeroCuenta(GeneradorCuenta.generarNumeroCuenta());

        cuenta.setFechaCreacion(LocalDate.now());
        cuenta.setFechaModificacion(LocalDate.now());

        cuentaRepository.save(cuenta);
    }

    public List<Cuenta> verCuenta(int id) {
        List<Cuenta> obtenerCuenta = cuentaRepository.getAccountById(id);
        return obtenerCuenta;
    }

    public BigDecimal verSaldo(int id) {
        BigDecimal saldoCuenta = cuentaRepository.getTotalBalance(id);
        return saldoCuenta;
    }

    public BigDecimal verSaldoAhorros(int id) {
        BigDecimal saldoCuenta = cuentaRepository.getBalanceAhorros(id);
        if(saldoCuenta == null){
            return BigDecimal.valueOf(0.0);
        } else {
            return saldoCuenta;
        }
    }

    public BigDecimal verSaldoCorriente(int id) {
        BigDecimal saldoCuenta = cuentaRepository.getBalanceCorriente(id);
        if(saldoCuenta == null){
            return BigDecimal.valueOf(0.0);
        } else {
            return saldoCuenta;
        }
    }

    public BigDecimal verGastosTarjeta(int id) {
        BigDecimal saldoCuenta = cuentaRepository.getBalanceCredito(id);
        if(saldoCuenta == null){
            return BigDecimal.valueOf(0.0);
        } else {
            return saldoCuenta;
        }
    }
}