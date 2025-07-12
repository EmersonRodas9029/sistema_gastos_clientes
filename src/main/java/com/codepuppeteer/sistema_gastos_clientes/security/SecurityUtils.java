package com.codepuppeteer.sistema_gastos_clientes.security;

import com.codepuppeteer.sistema_gastos_clientes.entity.Usuario;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {

    public static Usuario getUsuarioActual() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof UsuarioDetails details) {
            return details.getUsuario();
        }
        return null;
    }
}
