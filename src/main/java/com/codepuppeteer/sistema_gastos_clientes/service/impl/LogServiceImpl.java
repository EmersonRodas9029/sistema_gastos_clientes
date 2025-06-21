package com.codepuppeteer.sistema_gastos_clientes.service.impl;

import com.codepuppeteer.sistema_gastos_clientes.dto.DtoLogResponse;
import com.codepuppeteer.sistema_gastos_clientes.entity.Log;
import com.codepuppeteer.sistema_gastos_clientes.entity.Usuario;
import com.codepuppeteer.sistema_gastos_clientes.repository.LogRepository;
import com.codepuppeteer.sistema_gastos_clientes.repository.UsuarioRepository;
import com.codepuppeteer.sistema_gastos_clientes.service.LogService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    private final LogRepository logRepository;
    private final UsuarioRepository usuarioRepository;

    public LogServiceImpl(LogRepository logRepository, UsuarioRepository usuarioRepository) {
        this.logRepository = logRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void registrarAccion(String accion, Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));

        Log log = Log.builder()
                .accion(accion)
                .usuario(usuario)
                .build();

        logRepository.save(log);
    }

    @Override
    public List<DtoLogResponse> obtenerTodos() {
        return logRepository.findAll().stream().map(log ->
                new DtoLogResponse(
                        log.getId(),
                        log.getAccion(),
                        log.getFecha(),
                        log.getUsuario().getUsername()
                )
        ).toList();
    }
}
