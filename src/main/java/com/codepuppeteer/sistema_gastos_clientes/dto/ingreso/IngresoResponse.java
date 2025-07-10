package com.codepuppeteer.sistema_gastos_clientes.dto.ingreso;

import com.codepuppeteer.sistema_gastos_clientes.enums.TipoIngreso;
import com.codepuppeteer.sistema_gastos_clientes.enums.Frecuencia;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record IngresoResponse(
        Long id,
        Long clienteId,
        BigDecimal monto,
        LocalDate fecha,
        TipoIngreso tipo,
        String fuente,
        String descripcion,
        String metodoRecepcion,
        Boolean esRecurrente,
        Frecuencia frecuencia,
        Boolean activo,
        LocalDateTime fechaCreacion,
        LocalDateTime fechaModificacion
) {}
