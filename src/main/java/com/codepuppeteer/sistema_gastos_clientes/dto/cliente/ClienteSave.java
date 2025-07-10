package com.codepuppeteer.sistema_gastos_clientes.dto.cliente;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record ClienteSave(
        @NotNull(message = "El ID de usuario es obligatorio")
        Long usuarioId,

        @NotBlank(message = "El nombre completo es obligatorio")
        String nombreCompleto,

        @Size(max = 20)
        String telefono,

        @Email
        String email,

        LocalDate fechaNacimiento,

        String direccion,

        @NotBlank(message = "El documento de identidad es obligatorio")
        String documentoIdentidad,

        String tipoDocumento
) {}
