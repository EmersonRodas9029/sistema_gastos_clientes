package com.codepuppeteer.sistema_gastos_clientes.dto.meta;

import com.codepuppeteer.sistema_gastos_clientes.enums.Prioridad;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record MetaFinancieraSave(
        @NotNull(message = "El ID del cliente es obligatorio")
        Long clienteId,

        @NotBlank(message = "El nombre de la meta es obligatorio")
        String nombre,

        String descripcion,

        @NotNull(message = "El monto objetivo es obligatorio")
        @DecimalMin(value = "0.01", message = "El monto objetivo debe ser mayor que cero")
        BigDecimal montoObjetivo,

        @DecimalMin(value = "0.00", message = "El monto actual no puede ser negativo")
        BigDecimal montoActual,

        LocalDate fechaLimite,

        Prioridad prioridad
) {}
