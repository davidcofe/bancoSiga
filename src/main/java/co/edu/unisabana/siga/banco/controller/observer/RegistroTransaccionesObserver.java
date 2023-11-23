package co.edu.unisabana.siga.banco.controller.observer;

public class RegistroTransaccionesObserver implements TransaccionObserver {
    @Override
    public void notificarTransaccionExitosa(String tipoTransaccion, String numeroCuenta, double monto) {
        System.out.println("Transacción exitosa: " + tipoTransaccion + " - Cuenta: " + numeroCuenta + " - Monto: " + monto);
    }

    @Override
    public void notificarErrorEnTransaccion(String tipoTransaccion, String numeroCuenta, double monto, String mensajeError) {
        System.err.println("Error en la transacción: " + tipoTransaccion + " - Cuenta: " + numeroCuenta + " - Monto: " + monto + " - Mensaje de error: " + mensajeError);
    }
}