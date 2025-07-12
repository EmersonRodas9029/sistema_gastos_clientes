package com.codepuppeteer.sistema_gastos_clientes.service.interfaces;

import com.codepuppeteer.sistema_gastos_clientes.dto.categoria.*;

import java.util.List;

public interface CategoriaService {

    CategoriaResponse crearCategoria(CategoriaSave dto);

    CategoriaResponse actualizarCategoria(Long id, CategoriaUpdate dto);

    CategoriaResponse obtenerPorId(Long id);

    List<CategoriaList> listarPorCliente(Long clienteId);

    void desactivarCategoria(Long id);
}
