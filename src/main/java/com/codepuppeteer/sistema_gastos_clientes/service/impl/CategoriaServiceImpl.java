package com.codepuppeteer.sistema_gastos_clientes.service.impl;

import com.codepuppeteer.sistema_gastos_clientes.dto.categoria.*;
import com.codepuppeteer.sistema_gastos_clientes.entity.Categoria;
import com.codepuppeteer.sistema_gastos_clientes.entity.Cliente;
import com.codepuppeteer.sistema_gastos_clientes.exception.ResourceNotFoundException;
import com.codepuppeteer.sistema_gastos_clientes.mapper.CategoriaMapper;
import com.codepuppeteer.sistema_gastos_clientes.repository.CategoriaRepository;
import com.codepuppeteer.sistema_gastos_clientes.repository.ClienteRepository;
import com.codepuppeteer.sistema_gastos_clientes.service.interfaces.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final ClienteRepository clienteRepository;
    private final CategoriaMapper categoriaMapper;

    @Override
    public CategoriaResponse crearCategoria(CategoriaSave dto) {
        Cliente cliente = clienteRepository.findById(dto.clienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con ID: " + dto.clienteId()));

        Categoria categoria = categoriaMapper.toEntity(dto);
        categoria.setCliente(cliente);
        categoria.setActiva(true);
        categoria.setFechaCreacion(LocalDateTime.now());
        categoria.setFechaModificacion(LocalDateTime.now());

        return categoriaMapper.toResponse(categoriaRepository.save(categoria));
    }

    @Override
    public CategoriaResponse actualizarCategoria(Long id, CategoriaUpdate dto) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada con ID: " + id));

        categoriaMapper.updateFromDto(dto, categoria);
        categoria.setFechaModificacion(LocalDateTime.now());

        return categoriaMapper.toResponse(categoriaRepository.save(categoria));
    }

    @Override
    public CategoriaResponse obtenerPorId(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada con ID: " + id));

        return categoriaMapper.toResponse(categoria);
    }

    @Override
    public List<CategoriaList> listarPorCliente(Long clienteId) {
        return categoriaRepository.findByClienteIdAndActivaTrue(clienteId).stream()
                .map(categoriaMapper::toList)
                .toList();
    }

    @Override
    public void desactivarCategoria(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada con ID: " + id));

        categoria.setActiva(false);
        categoria.setFechaModificacion(LocalDateTime.now());
        categoriaRepository.save(categoria);
    }
}
