package com.codepuppeteer.sistema_gastos_clientes.service;

import com.codepuppeteer.sistema_gastos_clientes.dto.DtoClienteRequest;
import com.codepuppeteer.sistema_gastos_clientes.dto.DtoClienteResponse;

import java.util.List;

public interface ClienteService {

    DtoClienteResponse crearCliente(DtoClienteRequest dto);

    DtoClienteResponse actualizarCliente(Long id, DtoClienteRequest dto);

    void eliminarCliente(Long id);

    DtoClienteResponse obtenerClientePorId(Long id);

    List<DtoClienteResponse> listarClientes(String filtro);

}
