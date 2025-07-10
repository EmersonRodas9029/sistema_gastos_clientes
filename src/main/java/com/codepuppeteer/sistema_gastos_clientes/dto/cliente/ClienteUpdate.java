package com.codepuppeteer.sistema_gastos_clientes.dto.cliente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record ClienteUpdate(
        String nombreCompleto,

        @Size(max = 20)
        String telefono,

        @Email
        String email,

        LocalDate fechaNacimiento,

        String direccion,

        String documentoIdentidad,

        String tipoDocumento,

        Boolean activo
) {}
