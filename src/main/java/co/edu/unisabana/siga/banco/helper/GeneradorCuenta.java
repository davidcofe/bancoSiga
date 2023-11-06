package co.edu.unisabana.siga.banco.helper;

import java.security.SecureRandom;

public class GeneradorCuenta {

    private GeneradorCuenta() {
        throw new IllegalStateException("Utility class");
    }

    private static SecureRandom random = new SecureRandom();

    public static int generarNumeroCuenta(){
        int numeroCuenta;
        int bound = 1000;
        numeroCuenta = bound * random.nextInt(bound);
        return numeroCuenta;
    }
}
