package com.example.viagempelomundo.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SenhaUtils {

    public static String gerarHash(String senha) {

        try {

            MessageDigest digest =
                    MessageDigest.getInstance("SHA-256");

            byte[] hash =
                    digest.digest(
                            senha.getBytes(
                                    StandardCharsets.UTF_8
                            )
                    );

            StringBuilder resultado =
                    new StringBuilder();

            for (byte b : hash) {

                String hex =
                        Integer.toHexString(
                                0xff & b
                        );

                if (hex.length() == 1) {
                    resultado.append('0');
                }

                resultado.append(hex);
            }

            return resultado.toString();

        } catch (NoSuchAlgorithmException e) {

            throw new RuntimeException(e);
        }
    }
}