package com.codepuppeteer.sistema_gastos_clientes.util;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.UUID;

public class EncryptionUtils {

    private static final SecureRandom secureRandom = new SecureRandom();

    /**
     * Genera un token único para recuperación de contraseña u otros usos.
     */
    public static String generarTokenUnico() {
        return UUID.randomUUID().toString() + "-" + generarTokenAleatorio();
    }

    /**
     * Genera un string aleatorio en base64 seguro de 32 bytes.
     */
    public static String generarTokenAleatorio() {
        byte[] randomBytes = new byte[32];
        secureRandom.nextBytes(randomBytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);
    }
}
