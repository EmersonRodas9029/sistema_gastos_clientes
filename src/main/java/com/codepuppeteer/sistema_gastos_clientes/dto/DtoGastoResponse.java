package com.codepuppeteer.sistema_gastos_clientes.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DtoGastoResponse(
        Long id,
        LocalDate fecha,
        BigDecimal monto,
        String descripcion,
        String categoria,
        DtoClienteResponse cliente,
        DtoUsuarioResponse usuario
) {}
