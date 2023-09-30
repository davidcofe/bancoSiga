package co.edu.unisabana.siga.banco.logica;

import co.edu.unisabana.siga.banco.bd.CuentaRepository;
import co.edu.unisabana.siga.banco.bd.Historial;
import co.edu.unisabana.siga.banco.bd.HistorialRepository;
import co.edu.unisabana.siga.banco.controller.dto.CuentaDTO;
import co.edu.unisabana.siga.banco.controller.dto.HistorialDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class TransaccionLogica {
    private CuentaRepository cuentaRepository;
    private HistorialRepository historialRepository;

    public TransaccionLogica(CuentaRepository cuentaRepository, HistorialRepository historialRepository) {
        this.cuentaRepository = cuentaRepository;
        this.historialRepository = historialRepository;
    }

    public void depositar(String numeroCuenta, double deposito) {

        int cuentaId = Integer.parseInt(numeroCuenta);
        double cantidadDeposito = (deposito);
        double balanceActual = cuentaRepository.getBalanceCuenta(cuentaId);
        double nuevoBalance = balanceActual + cantidadDeposito;
        cuentaRepository.cambiarBalanceCuentaById(nuevoBalance, cuentaId);

        HistorialDTO historialDTO =
                new HistorialDTO(cuentaId, "DEPOSITO", BigDecimal.valueOf(cantidadDeposito));
        guardarMovimiento(historialDTO);
    }

    public void retirar(String numeroCuenta, double retiro) {

        int cuentaId = Integer.parseInt(numeroCuenta);
        double cantidadRetiro = (retiro);
        double balanceActual = cuentaRepository.getBalanceCuenta(cuentaId);
        double nuevoBalance = balanceActual - cantidadRetiro;
        cuentaRepository.cambiarBalanceCuentaById(nuevoBalance, cuentaId);

        HistorialDTO historialDTO =
                new HistorialDTO(cuentaId, "RETIRO", BigDecimal.valueOf(cantidadRetiro));
        guardarMovimiento(historialDTO);
    }

    public void pagos(String numeroCuenta, double pago) {

        int cuentaId = Integer.parseInt(numeroCuenta);
        double cantidadPago = (pago);
        double balanceActual = cuentaRepository.getBalanceCuenta(cuentaId);
        double nuevoBalance = balanceActual - cantidadPago;
        cuentaRepository.cambiarBalanceCuentaById(nuevoBalance, cuentaId);

        HistorialDTO historialDTO =
                new HistorialDTO(cuentaId, "PAGO", BigDecimal.valueOf(cantidadPago));
        guardarMovimiento(historialDTO);
    }

    public void transferencias(String numeroCuentaDe, String numeroCuentaHacia, double deposito) {
        double cantidadTransferencia = (deposito);

        int cuentaIdDe = Integer.parseInt(numeroCuentaDe);

        int cuentaIdHacia = Integer.parseInt(numeroCuentaHacia);

        double balanceActualDe = cuentaRepository.getBalanceCuenta(cuentaIdDe);
        double nuevoBalanceDe = balanceActualDe - cantidadTransferencia;

        double balanceActualHacia = cuentaRepository.getBalanceCuenta(cuentaIdHacia);
        double nuevoBalanceHacia = balanceActualHacia + cantidadTransferencia;

        cuentaRepository.cambiarBalanceCuentaById(nuevoBalanceDe, cuentaIdDe);
        cuentaRepository.cambiarBalanceCuentaById(nuevoBalanceHacia, cuentaIdHacia);

        HistorialDTO historialDTO =
                new HistorialDTO(cuentaIdDe, "TRANSFERENCIA_PAGO", BigDecimal.valueOf(cantidadTransferencia));
        guardarMovimiento(historialDTO);
        HistorialDTO historialDTO1 =
                new HistorialDTO(cuentaIdHacia, "TRANSFERENCIA_DEPOSITO", BigDecimal.valueOf(cantidadTransferencia));
        guardarMovimiento(historialDTO1);
    }

    public Historial guardarMovimiento(HistorialDTO historialDTO){
        Historial historial = new Historial();
        historial.setNumeroCuenta(historialDTO.getNumeroCuenta());
        historial.setTipoTransaccion(historialDTO.getTipoTransaccion());
        historial.setSaldo(historialDTO.getSaldo());

        historial.setFechaCreacion(LocalDate.now());

        historialRepository.save(historial);
        return historial;
    }
}
