package co.edu.unisabana.siga.banco.helper;

import java.util.UUID;

public class Token {
    public static String generateToken(){
        String token = UUID.randomUUID().toString();
        return token;
    }
}
