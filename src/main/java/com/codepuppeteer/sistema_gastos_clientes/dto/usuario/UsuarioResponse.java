package com.codepuppeteer.sistema_gastos_clientes.dto.usuario;

import com.codepuppeteer.sistema_gastos_clientes.enums.RolUsuario;

import java.time.LocalDateTime;

public record UsuarioResponse(
        Long id,
        String username,
        String email,
        RolUsuario rol,
        Boolean activo,
        LocalDateTime ultimoAcceso,
        int intentosFallidos,
        LocalDateTime bloqueadoHasta
) {}
