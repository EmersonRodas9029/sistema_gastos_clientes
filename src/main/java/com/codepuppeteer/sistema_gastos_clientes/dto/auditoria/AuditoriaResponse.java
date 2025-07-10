package com.codepuppeteer.sistema_gastos_clientes.dto.auditoria;

import com.codepuppeteer.sistema_gastos_clientes.enums.TipoAccion;

import java.time.LocalDateTime;

public record AuditoriaResponse(
        Long id,
        Long usuarioId,
        String tablaAfectada,
        TipoAccion accion,
        Long registroId,
        String datosAnterioresJson,
        String datosNuevosJson,
        String sessionId,
        String userAgent,
        String descripcion,
        LocalDateTime fechaEvento
) {}
