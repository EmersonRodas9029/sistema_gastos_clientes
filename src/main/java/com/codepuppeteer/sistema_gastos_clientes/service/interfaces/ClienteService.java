package com.codepuppeteer.sistema_gastos_clientes.service.interfaces;

import com.codepuppeteer.sistema_gastos_clientes.dto.cliente.*;

import java.util.List;

public interface ClienteService {

    ClienteResponse crearCliente(ClienteSave dto);

    ClienteResponse actualizarCliente(Long id, ClienteUpdate dto);

    ClienteResponse obtenerClientePorId(Long id);

    ClienteResponse obtenerClientePorUsuarioId(Long usuarioId);

    List<ClienteList> listarClientes();

    void desactivarCliente(Long id);
}
