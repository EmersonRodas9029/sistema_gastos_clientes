package com.codepuppeteer.sistema_gastos_clientes.service;

import com.codepuppeteer.sistema_gastos_clientes.dto.DtoGastoRequest;
import com.codepuppeteer.sistema_gastos_clientes.dto.DtoGastoResponse;

import java.time.LocalDate;
import java.util.List;

public interface GastoService {

    DtoGastoResponse crearGasto(DtoGastoRequest dto);

    DtoGastoResponse actualizarGasto(Long id, DtoGastoRequest dto);

    void eliminarGasto(Long id);

    DtoGastoResponse obtenerGastoPorId(Long id);

    List<DtoGastoResponse> listarGastosPorCliente(Long clienteId);

    List<DtoGastoResponse> filtrarGastos(LocalDate desde, LocalDate hasta, String categoria);

}
