package com.codepuppeteer.sistema_gastos_clientes.dto;

import java.time.LocalDateTime;

public record DtoLogResponse(
        Long id,
        String accion,
        LocalDateTime fecha,
        String usuario
) {}
