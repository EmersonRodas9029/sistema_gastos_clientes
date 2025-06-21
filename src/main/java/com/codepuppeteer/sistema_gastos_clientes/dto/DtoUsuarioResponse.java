package com.codepuppeteer.sistema_gastos_clientes.dto;

import java.time.LocalDateTime;

public record DtoUsuarioResponse(
        Long id,
        String username,
        String rol,
        boolean activo,
        LocalDateTime fechaCreacion,
        DtoClienteResponse cliente
) {}
