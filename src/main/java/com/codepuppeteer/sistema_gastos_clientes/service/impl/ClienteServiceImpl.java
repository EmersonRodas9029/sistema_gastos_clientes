package com.codepuppeteer.sistema_gastos_clientes.service.impl;

import com.codepuppeteer.sistema_gastos_clientes.dto.cliente.*;
import com.codepuppeteer.sistema_gastos_clientes.entity.Cliente;
import com.codepuppeteer.sistema_gastos_clientes.entity.Usuario;
import com.codepuppeteer.sistema_gastos_clientes.exception.ResourceNotFoundException;
import com.codepuppeteer.sistema_gastos_clientes.mapper.ClienteMapper;
import com.codepuppeteer.sistema_gastos_clientes.repository.ClienteRepository;
import com.codepuppeteer.sistema_gastos_clientes.repository.UsuarioRepository;
import com.codepuppeteer.sistema_gastos_clientes.service.interfaces.ClienteService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final UsuarioRepository usuarioRepository;
    private final ClienteMapper clienteMapper;

    @Override
    public ClienteResponse crearCliente(ClienteSave dto) {
        Usuario usuario = usuarioRepository.findById(dto.usuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con ID: " + dto.usuarioId()));

        Cliente cliente = clienteMapper.toEntity(dto);
        cliente.setUsuario(usuario);
        cliente.setActivo(true);
        cliente.setFechaCreacion(LocalDateTime.now());
        cliente.setFechaModificacion(LocalDateTime.now());

        return clienteMapper.toResponse(clienteRepository.save(cliente));
    }

    @Override
    public ClienteResponse actualizarCliente(Long id, ClienteUpdate dto) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con ID: " + id));

        clienteMapper.updateFromDto(dto, cliente);
        cliente.setFechaModificacion(LocalDateTime.now());

        return clienteMapper.toResponse(clienteRepository.save(cliente));
    }

    @Override
    public ClienteResponse obtenerClientePorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con ID: " + id));
        return clienteMapper.toResponse(cliente);
    }

    @Override
    public ClienteResponse obtenerClientePorUsuarioId(Long usuarioId) {
        Cliente cliente = clienteRepository.findByUsuarioId(usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con usuario ID: " + usuarioId));
        return clienteMapper.toResponse(cliente);
    }

    @Override
    public List<ClienteList> listarClientes() {
        return clienteRepository.findAll().stream()
                .map(clienteMapper::toList)
                .toList();
    }

    @Override
    public void desactivarCliente(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con ID: " + id));
        cliente.setActivo(false);
        cliente.setFechaModificacion(LocalDateTime.now());
        clienteRepository.save(cliente);
    }
}
