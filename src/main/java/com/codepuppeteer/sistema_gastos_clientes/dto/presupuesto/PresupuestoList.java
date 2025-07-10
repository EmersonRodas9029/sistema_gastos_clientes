package com.codepuppeteer.sistema_gastos_clientes.dto.presupuesto;

import java.math.BigDecimal;

public record PresupuestoList(
        Long id,
        String categoriaNombre,
        BigDecimal montoPresupuestado,
        Integer mes,
        Integer anio,
        Boolean activo
) {}
