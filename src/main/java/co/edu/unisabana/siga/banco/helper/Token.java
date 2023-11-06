package co.edu.unisabana.siga.banco.helper;

import java.util.UUID;

public class Token {

    private Token() {
        throw new IllegalStateException("Utility class");
    }
    public static String generateToken(){
        return UUID.randomUUID().toString();
    }
}
