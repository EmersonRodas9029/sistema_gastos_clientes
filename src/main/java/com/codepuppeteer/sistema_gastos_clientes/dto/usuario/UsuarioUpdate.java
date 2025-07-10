package com.codepuppeteer.sistema_gastos_clientes.dto.usuario;

import com.codepuppeteer.sistema_gastos_clientes.enums.RolUsuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record UsuarioUpdate(
        @Size(min = 4, max = 50)
        String username,

        @Size(min = 6)
        String password,

        @Email
        String email,

        RolUsuario rol,

        Boolean activo
) {}
