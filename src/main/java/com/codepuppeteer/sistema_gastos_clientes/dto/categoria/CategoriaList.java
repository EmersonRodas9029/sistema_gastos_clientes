package com.codepuppeteer.sistema_gastos_clientes.dto.categoria;

public record CategoriaList(
        Long id,
        String nombre,
        String icono,
        String color,
        Boolean activa
) {}
