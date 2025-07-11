package com.codepuppeteer.sistema_gastos_clientes.dto.common;

public record ApiResponse<T>(
        boolean exito,
        String mensaje,
        T datos
) { }
