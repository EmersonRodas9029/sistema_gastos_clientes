package com.codepuppeteer.sistema_gastos_clientes.dto.presupuesto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record PresupuestoSave(
        @NotNull(message = "El ID del cliente es obligatorio")
        Long clienteId,

        Long categoriaId,

        @NotNull(message = "El monto presupuestado es obligatorio")
        @DecimalMin(value = "0.01", message = "El monto debe ser mayor a 0")
        BigDecimal montoPresupuestado,

        @NotNull(message = "El mes es obligatorio")
        @Min(value = 1, message = "El mes debe estar entre 1 y 12")
        @Max(value = 12, message = "El mes debe estar entre 1 y 12")
        Integer mes,

        @NotNull(message = "El año es obligatorio")
        @Min(value = 2020, message = "Año inválido")
        @Max(value = 2050, message = "Año inválido")
        Integer anio
) {}
