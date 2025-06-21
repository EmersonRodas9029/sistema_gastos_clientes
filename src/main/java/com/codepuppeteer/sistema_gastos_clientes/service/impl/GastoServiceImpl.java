package com.codepuppeteer.sistema_gastos_clientes.service.impl;

import com.codepuppeteer.sistema_gastos_clientes.dto.*;
import com.codepuppeteer.sistema_gastos_clientes.entity.*;
import com.codepuppeteer.sistema_gastos_clientes.repository.*;
import com.codepuppeteer.sistema_gastos_clientes.service.GastoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GastoServiceImpl implements GastoService {

    private final GastoRepository gastoRepository;
    private final ClienteRepository clienteRepository;
    private final UsuarioRepository usuarioRepository;

    public GastoServiceImpl(GastoRepository gastoRepository,
                            ClienteRepository clienteRepository,
                            UsuarioRepository usuarioRepository) {
        this.gastoRepository = gastoRepository;
        this.clienteRepository = clienteRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public DtoGastoResponse crearGasto(DtoGastoRequest dto) {
        Cliente cliente = clienteRepository.findById(dto.clienteId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));

        Usuario usuario = usuarioRepository.findById(dto.usuarioId())
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));

        Gasto gasto = Gasto.builder()
                .fecha(dto.fecha())
                .monto(dto.monto())
                .descripcion(dto.descripcion())
                .categoria(dto.categoria())
                .cliente(cliente)
                .usuario(usuario)
                .build();

        gastoRepository.save(gasto);
        return toDto(gasto);
    }

    @Override
    public DtoGastoResponse actualizarGasto(Long id, DtoGastoRequest dto) {
        Gasto gasto = gastoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Gasto no encontrado"));

        Cliente cliente = clienteRepository.findById(dto.clienteId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));

        Usuario usuario = usuarioRepository.findById(dto.usuarioId())
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));

        gasto.setFecha(dto.fecha());
        gasto.setMonto(dto.monto());
        gasto.setDescripcion(dto.descripcion());
        gasto.setCategoria(dto.categoria());
        gasto.setCliente(cliente);
        gasto.setUsuario(usuario);

        gastoRepository.save(gasto);
        return toDto(gasto);
    }

    @Override
    public void eliminarGasto(Long id) {
        gastoRepository.deleteById(id);
    }

    @Override
    public DtoGastoResponse obtenerGastoPorId(Long id) {
        Gasto gasto = gastoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Gasto no encontrado"));
        return toDto(gasto);
    }

    @Override
    public List<DtoGastoResponse> listarGastosPorCliente(Long clienteId) {
        return gastoRepository.findByClienteId(clienteId).stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public List<DtoGastoResponse> filtrarGastos(java.time.LocalDate desde, java.time.LocalDate hasta, String categoria) {
        return gastoRepository.findByFechaBetween(desde, hasta).stream()
                .filter(g -> categoria == null || g.getCategoria().equalsIgnoreCase(categoria))
                .map(this::toDto)
                .toList();
    }

    private DtoGastoResponse toDto(Gasto gasto) {
        var cliente = gasto.getCliente();
        var usuario = gasto.getUsuario();

        DtoClienteResponse clienteDto = new DtoClienteResponse(
                cliente.getId(),
                cliente.getNombre(),
                cliente.getDui(),
                cliente.getNit(),
                cliente.getEmpresa(),
                cliente.getTelefono(),
                cliente.getCorreo(),
                cliente.getFechaCreacion()
        );

        DtoUsuarioResponse usuarioDto = new DtoUsuarioResponse(
                usuario.getId(),
                usuario.getUsername(),
                usuario.getRol().name(),
                usuario.getActivo(),
                usuario.getFechaCreacion(),
                null
        );

        return new DtoGastoResponse(
                gasto.getId(),
                gasto.getFecha(),
                gasto.getMonto(),
                gasto.getDescripcion(),
                gasto.getCategoria(),
                clienteDto,
                usuarioDto
        );
    }
}
