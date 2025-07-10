package com.codepuppeteer.sistema_gastos_clientes.dto.gastorecurrente;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.validation.constraints.*;

public record GastoRecurrenteSave(
        @NotNull(message = "clienteId es obligatorio")
        Long clienteId,

        Long categoriaId,

        @NotNull(message = "monto es obligatorio")
        @DecimalMin(value = "0.01", message = "monto debe ser mayor a 0")
        BigDecimal monto,

        String descripcion,

        @NotNull(message = "frecuencia es obligatoria")
        String frecuencia,

        @NotNull(message = "fechaInicio es obligatoria")
        LocalDate fechaInicio,

        LocalDate fechaFin,

        @Min(value = 1, message = "diaMes debe estar entre 1 y 31")
        @Max(value = 31, message = "diaMes debe estar entre 1 y 31")
        Integer diaMes,

        @Min(value = 1, message = "diaSemana debe estar entre 1 y 7")
        @Max(value = 7, message = "diaSemana debe estar entre 1 y 7")
        Integer diaSemana,

        Boolean activo
) {}
