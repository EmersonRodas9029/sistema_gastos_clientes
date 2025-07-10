package com.codepuppeteer.sistema_gastos_clientes.dto.categoria;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record CategoriaSave(
        @NotNull(message = "El ID del cliente es obligatorio")
        Long clienteId,

        @NotBlank(message = "El nombre de la categoría es obligatorio")
        String nombre,

        String descripcion,

        @Pattern(regexp = "^#([A-Fa-f0-9]{6})$", message = "El color debe estar en formato hexadecimal")
        String color,

        String icono,

        @DecimalMin(value = "0.00", message = "El presupuesto mensual debe ser mayor o igual a cero")
        BigDecimal presupuestoMensual
) {}
