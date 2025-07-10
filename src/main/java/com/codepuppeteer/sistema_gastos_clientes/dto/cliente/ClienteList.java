package com.codepuppeteer.sistema_gastos_clientes.dto.cliente;

public record ClienteList(
        Long id,
        String nombreCompleto,
        String email,
        String telefono,
        Boolean activo
) {}
