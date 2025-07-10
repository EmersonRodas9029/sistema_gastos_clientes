package com.codepuppeteer.sistema_gastos_clientes.dto.gastorecurrente;

import java.math.BigDecimal;
import java.time.LocalDate;

public record GastoRecurrenteList(
        Long id,
        BigDecimal monto,
        String descripcion,
        String frecuencia,
        LocalDate fechaInicio,
        Boolean activo
) {}
