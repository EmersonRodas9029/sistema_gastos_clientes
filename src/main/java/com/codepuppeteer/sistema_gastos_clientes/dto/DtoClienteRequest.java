package com.codepuppeteer.sistema_gastos_clientes.dto;

import jakarta.validation.constraints.*;

public record DtoClienteRequest(
        @NotBlank String nombre,
        @NotBlank @Size(min = 10, max = 10) String dui,
        @NotBlank String nit,
        String empresa,
        String telefono,
        @Email String correo
) {}
