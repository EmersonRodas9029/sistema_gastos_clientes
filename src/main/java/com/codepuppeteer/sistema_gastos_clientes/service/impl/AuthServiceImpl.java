package com.codepuppeteer.sistema_gastos_clientes.service.impl;

import com.codepuppeteer.sistema_gastos_clientes.dto.usuario.UsuarioSave;
import com.codepuppeteer.sistema_gastos_clientes.dto.usuario.UsuarioResponse;
import com.codepuppeteer.sistema_gastos_clientes.entity.Usuario;
import com.codepuppeteer.sistema_gastos_clientes.enums.RolUsuario;
import com.codepuppeteer.sistema_gastos_clientes.exception.BusinessException;
import com.codepuppeteer.sistema_gastos_clientes.mapper.UsuarioMapper;
import com.codepuppeteer.sistema_gastos_clientes.repository.UsuarioRepository;
import com.codepuppeteer.sistema_gastos_clientes.service.interfaces.AuthService;
import com.codepuppeteer.sistema_gastos_clientes.util.EncryptionUtils;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final UsuarioMapper usuarioMapper;

    private static final String CLAVE_AUTORIZACION_CONTADOR = "9029";

    @Override
    public UsuarioResponse registrarCliente(UsuarioSave request) {
        if (usuarioRepository.existsByUsername(request.username())) {
            throw new BusinessException("El nombre de usuario ya está en uso.");
        }

        Usuario usuario = usuarioMapper.toEntity(request);
        usuario.setRol(RolUsuario.CLIENTE);
        usuario.setPassword(passwordEncoder.encode(request.password()));
        usuario.setActivo(true);
        usuario.setFechaCreacion(LocalDateTime.now());
        usuario.setFechaModificacion(LocalDateTime.now());

        return usuarioMapper.toResponse(usuarioRepository.save(usuario));
    }

    @Override
    public UsuarioResponse registrarContador(UsuarioSave request, String claveAutorizacion) {
        if (!CLAVE_AUTORIZACION_CONTADOR.equals(claveAutorizacion)) {
            throw new BusinessException("Clave de autorización incorrecta.");
        }

        if (usuarioRepository.existsByUsername(request.username())) {
            throw new BusinessException("El nombre de usuario ya está en uso.");
        }

        Usuario usuario = usuarioMapper.toEntity(request);
        usuario.setRol(RolUsuario.CONTADOR);
        usuario.setPassword(passwordEncoder.encode(request.password()));
        usuario.setActivo(true);
        usuario.setFechaCreacion(LocalDateTime.now());
        usuario.setFechaModificacion(LocalDateTime.now());

        return usuarioMapper.toResponse(usuarioRepository.save(usuario));
    }

    @Override
    public void iniciarSesion(String username, String password) {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new BusinessException("Usuario no encontrado."));

        if (!usuario.getActivo()) {
            throw new BusinessException("Cuenta inactiva o bloqueada.");
        }

        if (!passwordEncoder.matches(password, usuario.getPassword())) {
            throw new BusinessException("Contraseña incorrecta.");
        }

        usuario.setUltimoAcceso(LocalDateTime.now());
        usuario.setIntentosFallidos(0);
        usuarioRepository.save(usuario);

        // Aquí se podría registrar el evento en auditoría (sección posterior)
    }

    @Override
    public void logout(String username) {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElse(null);
        if (usuario != null) {
            // Aquí podrías guardar un evento de logout en auditoría
        }
    }

    @Override
    public void recuperarPassword(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new BusinessException("Email no registrado."));

        String token = EncryptionUtils.generarTokenUnico();
        usuario.setTokenRecuperacion(token);
        usuario.setFechaExpiracionToken(LocalDateTime.now().plusHours(2));
        usuarioRepository.save(usuario);

        // Aquí llamaríamos a EmailService para enviar correo de recuperación (en la siguiente etapa)
    }
}
