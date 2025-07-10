package com.codepuppeteer.sistema_gastos_clientes.dto.ingreso;

import com.codepuppeteer.sistema_gastos_clientes.enums.TipoIngreso;
import com.codepuppeteer.sistema_gastos_clientes.enums.Frecuencia;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record IngresoSave(
        @NotNull(message = "El ID del cliente es obligatorio")
        Long clienteId,

        @NotNull(message = "El monto es obligatorio")
        @DecimalMin(value = "0.01", message = "El monto debe ser mayor a 0")
        BigDecimal monto,

        @NotNull(message = "La fecha es obligatoria")
        LocalDate fecha,

        @NotNull(message = "El tipo de ingreso es obligatorio")
        TipoIngreso tipo,

        String fuente,
        String descripcion,

        String metodoRecepcion,

        Boolean esRecurrente,
        Frecuencia frecuencia
) {}
