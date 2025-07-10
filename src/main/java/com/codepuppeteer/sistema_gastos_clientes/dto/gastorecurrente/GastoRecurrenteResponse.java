package com.codepuppeteer.sistema_gastos_clientes.dto.gastorecurrente;

import java.math.BigDecimal;
import java.time.LocalDate;

public record GastoRecurrenteResponse(
        Long id,
        Long clienteId,
        Long categoriaId,
        BigDecimal monto,
        String descripcion,
        String frecuencia,
        LocalDate fechaInicio,
        LocalDate fechaFin,
        Integer diaMes,
        Integer diaSemana,
        Boolean activo,
        LocalDate ultimoProcesamiento,
        String fechaCreacion,
        String fechaModificacion
) {}
