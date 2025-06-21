package com.codepuppeteer.sistema_gastos_clientes.service.impl;

import com.codepuppeteer.sistema_gastos_clientes.dto.*;
import com.codepuppeteer.sistema_gastos_clientes.entity.Cliente;
import com.codepuppeteer.sistema_gastos_clientes.entity.Usuario;
import com.codepuppeteer.sistema_gastos_clientes.repository.ClienteRepository;
import com.codepuppeteer.sistema_gastos_clientes.repository.UsuarioRepository;
import com.codepuppeteer.sistema_gastos_clientes.service.UsuarioService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final ClienteRepository clienteRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository,
                              ClienteRepository clienteRepository,
                              PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.clienteRepository = clienteRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public DtoUsuarioResponse registrarUsuario(DtoUsuarioRequest dto) {
        Usuario usuario = new Usuario();
        usuario.setUsername(dto.username());
        usuario.setPassword(passwordEncoder.encode(dto.password()));
        usuario.setRol(Usuario.Rol.valueOf(dto.rol()));
        usuario.setActivo(true);

        if (dto.clienteId() != null) {
            Cliente cliente = clienteRepository.findById(dto.clienteId())
                    .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));
            usuario.setCliente(cliente);
        }

        usuarioRepository.save(usuario);
        return toDto(usuario);
    }

    @Override
    public DtoUsuarioResponse obtenerUsuarioPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));
        return toDto(usuario);
    }

    @Override
    public List<DtoUsuarioResponse> listarUsuarios() {
        return usuarioRepository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public void cambiarEstadoUsuario(Long id, boolean activo) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));
        usuario.setActivo(activo);
        usuarioRepository.save(usuario);
    }

    @Override
    public DtoUsuarioResponse obtenerPorUsername(String username) {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));
        return toDto(usuario);
    }

    private DtoUsuarioResponse toDto(Usuario usuario) {
        DtoClienteResponse clienteDto = null;
        if (usuario.getCliente() != null) {
            var cliente = usuario.getCliente();
            clienteDto = new DtoClienteResponse(
                    cliente.getId(),
                    cliente.getNombre(),
                    cliente.getDui(),
                    cliente.getNit(),
                    cliente.getEmpresa(),
                    cliente.getTelefono(),
                    cliente.getCorreo(),
                    cliente.getFechaCreacion()
            );
        }

        return new DtoUsuarioResponse(
                usuario.getId(),
                usuario.getUsername(),
                usuario.getRol().name(),
                usuario.getActivo(),
                usuario.getFechaCreacion(),
                clienteDto
        );
    }
}
