package com.codepuppeteer.sistema_gastos_clientes.dto.reporte;

import com.codepuppeteer.sistema_gastos_clientes.enums.TipoReporte;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record ReporteSave(
        @NotNull(message = "El ID del cliente es obligatorio")
        Long clienteId,

        Long contadorId,

        @NotBlank(message = "El nombre del reporte es obligatorio")
        String nombre,

        @NotNull(message = "El tipo de reporte es obligatorio")
        TipoReporte tipoReporte,

        @NotNull(message = "La fecha de inicio del periodo es obligatoria")
        LocalDate periodoInicio,

        @NotNull(message = "La fecha de fin del periodo es obligatoria")
        @FutureOrPresent(message = "La fecha de fin no puede ser anterior a hoy")
        LocalDate periodoFin,

        String contenidoJson,

        String rutaArchivo
) {}
