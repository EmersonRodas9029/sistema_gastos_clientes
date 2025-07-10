package com.codepuppeteer.sistema_gastos_clientes.dto.usuario;

import com.codepuppeteer.sistema_gastos_clientes.enums.RolUsuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UsuarioSave(
        @NotBlank(message = "El username es obligatorio")
        @Size(min = 4, max = 50)
        String username,

        @NotBlank(message = "La contraseña es obligatoria")
        @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
        String password,

        @Email(message = "Correo inválido")
        String email,

        @NotNull(message = "El rol es obligatorio")
        RolUsuario rol
) {}
