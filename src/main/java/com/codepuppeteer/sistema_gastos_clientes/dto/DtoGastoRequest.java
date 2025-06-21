package com.codepuppeteer.sistema_gastos_clientes.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public record DtoGastoRequest(
        @NotNull LocalDate fecha,
        @NotNull @DecimalMin("0.01") BigDecimal monto,
        String descripcion,
        String categoria,
        Long clienteId,
        Long usuarioId
) {}
