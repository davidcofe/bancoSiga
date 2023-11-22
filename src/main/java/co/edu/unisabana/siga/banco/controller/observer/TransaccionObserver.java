package co.edu.unisabana.siga.banco.controller.observer;

public interface TransaccionObserver {
    void notificarTransaccionExitosa(String tipoTransaccion, String numeroCuenta, double monto);
    void notificarErrorEnTransaccion(String tipoTransaccion, String numeroCuenta, double monto, String mensajeError);
}
