package com.codepuppeteer.sistema_gastos_clientes.service;

import com.codepuppeteer.sistema_gastos_clientes.dto.DtoUsuarioRequest;
import com.codepuppeteer.sistema_gastos_clientes.dto.DtoUsuarioResponse;

import java.util.List;

public interface UsuarioService {

    DtoUsuarioResponse registrarUsuario(DtoUsuarioRequest dto);

    DtoUsuarioResponse obtenerUsuarioPorId(Long id);

    List<DtoUsuarioResponse> listarUsuarios();

    void cambiarEstadoUsuario(Long id, boolean activo);

    DtoUsuarioResponse obtenerPorUsername(String username);

}
