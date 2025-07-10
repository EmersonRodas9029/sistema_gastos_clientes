package com.codepuppeteer.sistema_gastos_clientes.dto.gastorecurrente;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.validation.constraints.*;

public record GastoRecurrenteUpdate(
        @NotNull(message = "id es obligatorio")
        Long id,

        Long categoriaId,

        @DecimalMin(value = "0.01", message = "monto debe ser mayor a 0")
        BigDecimal monto,

        String descripcion,

        String frecuencia,

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
