package com.codepuppeteer.sistema_gastos_clientes.dto.cuenta;

import java.math.BigDecimal;

public record CuentaBancariaList(
        Long id,
        String banco,
        String numeroCuenta,
        String tipoCuenta,
        BigDecimal saldoActual,
        Boolean activa
) {}
