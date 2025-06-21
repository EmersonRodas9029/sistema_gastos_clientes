package com.codepuppeteer.sistema_gastos_clientes.service.impl;

import com.codepuppeteer.sistema_gastos_clientes.dto.*;
import com.codepuppeteer.sistema_gastos_clientes.entity.Cliente;
import com.codepuppeteer.sistema_gastos_clientes.repository.ClienteRepository;
import com.codepuppeteer.sistema_gastos_clientes.service.ClienteService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public DtoClienteResponse crearCliente(DtoClienteRequest dto) {
        Cliente cliente = Cliente.builder()
                .nombre(dto.nombre())
                .dui(dto.dui())
                .nit(dto.nit())
                .empresa(dto.empresa())
                .telefono(dto.telefono())
                .correo(dto.correo())
                .build();

        clienteRepository.save(cliente);
        return toDto(cliente);
    }

    @Override
    public DtoClienteResponse actualizarCliente(Long id, DtoClienteRequest dto) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));

        cliente.setNombre(dto.nombre());
        cliente.setDui(dto.dui());
        cliente.setNit(dto.nit());
        cliente.setEmpresa(dto.empresa());
        cliente.setTelefono(dto.telefono());
        cliente.setCorreo(dto.correo());

        clienteRepository.save(cliente);
        return toDto(cliente);
    }

    @Override
    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public DtoClienteResponse obtenerClientePorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));
        return toDto(cliente);
    }

    @Override
    public List<DtoClienteResponse> listarClientes(String filtro) {
        if (filtro == null || filtro.isBlank()) {
            return clienteRepository.findAll().stream().map(this::toDto).toList();
        }
        return clienteRepository.findByNombreContainingIgnoreCase(filtro).stream().map(this::toDto).toList();
    }

    private DtoClienteResponse toDto(Cliente cliente) {
        return new DtoClienteResponse(
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
}
