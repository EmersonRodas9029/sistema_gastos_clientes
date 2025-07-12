package com.codepuppeteer.sistema_gastos_clientes.service.interfaces;

import com.codepuppeteer.sistema_gastos_clientes.dto.usuario.UsuarioSave;
import com.codepuppeteer.sistema_gastos_clientes.dto.usuario.UsuarioResponse;

public interface AuthService {

    UsuarioResponse registrarCliente(UsuarioSave request);

    UsuarioResponse registrarContador(UsuarioSave request, String claveAutorizacion);

    void iniciarSesion(String username, String password);

    void logout(String username);

    void recuperarPassword(String email);
}
