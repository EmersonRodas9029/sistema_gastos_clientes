package com.codepuppeteer.sistema_gastos_clientes.dto.meta;

import java.math.BigDecimal;
import java.time.LocalDate;

public record MetaFinancieraList(
        Long id,
        String nombre,
        BigDecimal montoObjetivo,
        BigDecimal montoActual,
        LocalDate fechaLimite,
        Boolean completada
) {}
