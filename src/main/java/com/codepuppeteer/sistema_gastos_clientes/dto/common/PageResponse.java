package com.codepuppeteer.sistema_gastos_clientes.dto.common;

import java.util.List;

public record PageResponse<T>(
        List<T> contenido,
        int pagina,
        int tamanio,
        long totalElementos,
        int totalPaginas,
        boolean ultima
) { }
