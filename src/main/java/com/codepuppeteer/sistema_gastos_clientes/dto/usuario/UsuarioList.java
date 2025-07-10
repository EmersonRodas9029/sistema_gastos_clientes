package com.codepuppeteer.sistema_gastos_clientes.dto.usuario;

import com.codepuppeteer.sistema_gastos_clientes.enums.RolUsuario;

public record UsuarioList(
        Long id,
        String username,
        String email,
        RolUsuario rol,
        Boolean activo
) {}
