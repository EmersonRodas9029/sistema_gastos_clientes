package com.codepuppeteer.sistema_gastos_clientes.dto.gasto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record GastoList(
        Long id,
        String categoriaNombre,
        BigDecimal monto,
        LocalDate fecha,
        String descripcion,
        Boolean esRecurrente
) {}
