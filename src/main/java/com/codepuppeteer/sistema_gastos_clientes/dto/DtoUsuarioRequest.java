package com.codepuppeteer.sistema_gastos_clientes.dto;

import jakarta.validation.constraints.*;

public record DtoUsuarioRequest(
        @NotBlank String username,
        @NotBlank String password,
        @NotBlank String rol, // CONTADOR, ASISTENTE, CLIENTE
        Long clienteId // puede ser null para CONTADOR o ASISTENTE
) {}
