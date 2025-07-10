package com.codepuppeteer.sistema_gastos_clientes.dto.notificacion;

import com.codepuppeteer.sistema_gastos_clientes.enums.TipoNotificacion;

import java.time.LocalDateTime;

public record NotificacionUpdate(
        TipoNotificacion tipo,
        String titulo,
        String mensaje,
        Boolean leida,
        Boolean activa,
        LocalDateTime fechaProgramada,
        LocalDateTime fechaEnviada
) {}
