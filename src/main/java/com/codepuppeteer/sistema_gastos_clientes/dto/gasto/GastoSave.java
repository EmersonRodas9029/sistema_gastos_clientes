package com.codepuppeteer.sistema_gastos_clientes.dto.gasto;

import com.codepuppeteer.sistema_gastos_clientes.enums.MetodoPago;
import com.codepuppeteer.sistema_gastos_clientes.enums.Frecuencia;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record GastoSave(
        @NotNull(message = "El ID del cliente es obligatorio")
        Long clienteId,

        Long categoriaId,

        @NotNull(message = "El monto es obligatorio")
        @DecimalMin(value = "0.01", message = "El monto debe ser mayor a 0")
        BigDecimal monto,

        @NotNull(message = "La fecha es obligatoria")
        LocalDate fecha,

        String descripcion,

        MetodoPago metodoPago,

        Boolean esRecurrente,

        Frecuencia frecuencia,

        String adjunto
) {}
