package com.codepuppeteer.sistema_gastos_clientes.dto.cliente;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ClienteResponse(
        Long id,
        Long usuarioId,
        String nombreCompleto,
        String telefono,
        String email,
        LocalDate fechaNacimiento,
        String direccion,
        String documentoIdentidad,
        String tipoDocumento,
        Boolean activo,
        LocalDateTime fechaCreacion,
        LocalDateTime fechaModificacion
) {}
