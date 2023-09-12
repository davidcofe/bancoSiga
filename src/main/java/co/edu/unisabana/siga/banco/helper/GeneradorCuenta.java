package co.edu.unisabana.siga.banco.helper;

import java.util.Random;

public class GeneradorCuenta {
    public static int generarNumeroCuenta(){
        Random random = new Random();
        int numeroCuenta;
        int bound = 1000;
        numeroCuenta = bound * random.nextInt(bound);
        return numeroCuenta;
    }
}
