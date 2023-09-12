package co.edu.unisabana.siga.banco.logica;

import co.edu.unisabana.siga.banco.bd.CuentaRepository;
import co.edu.unisabana.siga.banco.bd.Historial;
import co.edu.unisabana.siga.banco.bd.HistorialRepository;
import co.edu.unisabana.siga.banco.controller.dto.CuentaDTO;
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

    public void depositar(String numero_cuenta, String deposito) {

        int cuentaId = Integer.parseInt(numero_cuenta);
        double cantidadDeposito = Double.parseDouble(deposito);
        double balanceActual = cuentaRepository.getBalanceCuenta(cuentaId);
        double nuevoBalance = balanceActual + cantidadDeposito;
        cuentaRepository.cambiarBalanceCuentaById(nuevoBalance, cuentaId);

        guardarMovimiento(numero_cuenta, "DEPOSITO", cantidadDeposito);
    }

    public void retirar(String numero_cuenta, String retiro) {

        int cuentaId = Integer.parseInt(numero_cuenta);
        double cantidadRetiro = Double.parseDouble(retiro);
        double balanceActual = cuentaRepository.getBalanceCuenta(cuentaId);
        double nuevoBalance = balanceActual - cantidadRetiro;
        cuentaRepository.cambiarBalanceCuentaById(nuevoBalance, cuentaId);

        guardarMovimiento(numero_cuenta, "RETIRO", cantidadRetiro);
    }

    public void pagos(String numero_cuenta, String pago) {

        int cuentaId = Integer.parseInt(numero_cuenta);
        double cantidadPago = Double.parseDouble(pago);
        double balanceActual = cuentaRepository.getBalanceCuenta(cuentaId);
        double nuevoBalance = balanceActual - cantidadPago;
        cuentaRepository.cambiarBalanceCuentaById(nuevoBalance, cuentaId);

        guardarMovimiento(numero_cuenta, "PAGO", cantidadPago);
    }

    public void transferencias(String numero_cuentaDe, String numero_cuentaHacia,String deposito) {
        double cantidadTransferencia = Double.parseDouble(deposito);

        int cuentaIdDe = Integer.parseInt(numero_cuentaDe);

        int cuentaIdHacia = Integer.parseInt(numero_cuentaHacia);

        double balanceActualDe = cuentaRepository.getBalanceCuenta(cuentaIdDe);
        double nuevoBalanceDe = balanceActualDe - cantidadTransferencia;

        double balanceActualHacia = cuentaRepository.getBalanceCuenta(cuentaIdHacia);
        double nuevoBalanceHacia = balanceActualHacia + cantidadTransferencia;

        cuentaRepository.cambiarBalanceCuentaById(nuevoBalanceDe, cuentaIdDe);
        cuentaRepository.cambiarBalanceCuentaById(nuevoBalanceHacia, cuentaIdHacia);

        guardarMovimiento(numero_cuentaDe, "TRANSFERENCIA_PAGO", cantidadTransferencia);
        guardarMovimiento(numero_cuentaHacia, "TRANSFERENCIA_DEPOSITO", cantidadTransferencia);
    }

    public void guardarMovimiento(String numero_cuenta, String tipo_transaccion, double saldo){
        Historial historial = new Historial();
        historial.setNumeroCuenta(Integer.parseInt(numero_cuenta));
        historial.setTipoTransaccion(tipo_transaccion);
        historial.setSaldo(BigDecimal.valueOf(saldo));

        historial.setFechaCreacion(LocalDate.now());
        historialRepository.save(historial);
    }
}
