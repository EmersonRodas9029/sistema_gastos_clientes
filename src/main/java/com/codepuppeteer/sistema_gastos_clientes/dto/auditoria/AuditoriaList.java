package com.codepuppeteer.sistema_gastos_clientes.dto.auditoria;

import com.codepuppeteer.sistema_gastos_clientes.enums.TipoAccion;

import java.time.LocalDateTime;

public record AuditoriaList(
        Long id,
        String tablaAfectada,
        TipoAccion accion,
        Long registroId,
        LocalDateTime fechaEvento
) {}
