package com.codepuppeteer.sistema_gastos_clientes.dto.categoria;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;

public record CategoriaUpdate(
        String nombre,
        String descripcion,

        @Pattern(regexp = "^#([A-Fa-f0-9]{6})$")
        String color,

        String icono,

        @DecimalMin(value = "0.00")
        BigDecimal presupuestoMensual,

        Boolean activa
) {}
