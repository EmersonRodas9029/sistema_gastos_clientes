package com.codepuppeteer.sistema_gastos_clientes.service.interfaces;

import com.codepuppeteer.sistema_gastos_clientes.dto.gasto.*;

import java.time.LocalDate;
import java.util.List;

public interface GastoService {

    GastoResponse registrarGasto(GastoSave dto);

    GastoResponse actualizarGasto(Long id, GastoUpdate dto);

    GastoResponse obtenerPorId(Long id);

    List<GastoList> listarPorCliente(Long clienteId);

    List<GastoList> listarPorClienteYRangoFecha(Long clienteId, LocalDate desde, LocalDate hasta);

    void eliminarGasto(Long id);
}
