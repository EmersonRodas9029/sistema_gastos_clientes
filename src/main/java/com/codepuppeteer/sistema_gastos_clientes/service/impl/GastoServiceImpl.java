package com.codepuppeteer.sistema_gastos_clientes.service.impl;

import com.codepuppeteer.sistema_gastos_clientes.dto.gasto.*;
import com.codepuppeteer.sistema_gastos_clientes.entity.*;
import com.codepuppeteer.sistema_gastos_clientes.exception.ResourceNotFoundException;
import com.codepuppeteer.sistema_gastos_clientes.mapper.GastoMapper;
import com.codepuppeteer.sistema_gastos_clientes.repository.CategoriaRepository;
import com.codepuppeteer.sistema_gastos_clientes.repository.ClienteRepository;
import com.codepuppeteer.sistema_gastos_clientes.repository.GastoRepository;
import com.codepuppeteer.sistema_gastos_clientes.service.interfaces.GastoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GastoServiceImpl implements GastoService {

    private final GastoRepository gastoRepository;
    private final ClienteRepository clienteRepository;
    private final CategoriaRepository categoriaRepository;
    private final GastoMapper gastoMapper;

    @Override
    public GastoResponse registrarGasto(GastoSave dto) {
        Cliente cliente = clienteRepository.findById(dto.clienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con ID: " + dto.clienteId()));

        Categoria categoria = null;
        if (dto.categoriaId() != null) {
            categoria = categoriaRepository.findById(dto.categoriaId())
                    .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada con ID: " + dto.categoriaId()));
        }

        Gasto gasto = gastoMapper.toEntity(dto);
        gasto.setCliente(cliente);
        gasto.setCategoria(categoria);
        gasto.setActivo(true);
        gasto.setFechaCreacion(LocalDateTime.now());
        gasto.setFechaModificacion(LocalDateTime.now());

        return gastoMapper.toResponse(gastoRepository.save(gasto));
    }

    @Override
    public GastoResponse actualizarGasto(Long id, GastoUpdate dto) {
        Gasto gasto = gastoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Gasto no encontrado con ID: " + id));

        if (dto.categoriaId() != null) {
            Categoria categoria = categoriaRepository.findById(dto.categoriaId())
                    .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada con ID: " + dto.categoriaId()));
            gasto.setCategoria(categoria);
        }

        gastoMapper.updateFromDto(dto, gasto);
        gasto.setFechaModificacion(LocalDateTime.now());

        return gastoMapper.toResponse(gastoRepository.save(gasto));
    }

    @Override
    public GastoResponse obtenerPorId(Long id) {
        Gasto gasto = gastoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Gasto no encontrado con ID: " + id));
        return gastoMapper.toResponse(gasto);
    }

    @Override
    public List<GastoList> listarPorCliente(Long clienteId) {
        return gastoRepository.findByClienteIdAndActivoTrue(clienteId).stream()
                .map(gastoMapper::toList)
                .toList();
    }

    @Override
    public List<GastoList> listarPorClienteYRangoFecha(Long clienteId, LocalDate desde, LocalDate hasta) {
        return gastoRepository.findByClienteIdAndFechaBetweenAndActivoTrue(clienteId, desde, hasta).stream()
                .map(gastoMapper::toList)
                .toList();
    }

    @Override
    public void eliminarGasto(Long id) {
        Gasto gasto = gastoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Gasto no encontrado con ID: " + id));
        gasto.setActivo(false);
        gasto.setFechaModificacion(LocalDateTime.now());
        gastoRepository.save(gasto);
    }
}
