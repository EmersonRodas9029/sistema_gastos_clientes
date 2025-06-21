package com.codepuppeteer.sistema_gastos_clientes.service;

import com.codepuppeteer.sistema_gastos_clientes.dto.DtoLogResponse;

import java.util.List;

public interface LogService {

    void registrarAccion(String accion, Long usuarioId);

    List<DtoLogResponse> obtenerTodos();

}
