package com.codepuppeteer.sistema_gastos_clientes.dto;

import java.time.LocalDateTime;

public record DtoClienteResponse(
        Long id,
        String nombre,
        String dui,
        String nit,
        String empresa,
        String telefono,
        String correo,
        LocalDateTime fechaCreacion
) {}
