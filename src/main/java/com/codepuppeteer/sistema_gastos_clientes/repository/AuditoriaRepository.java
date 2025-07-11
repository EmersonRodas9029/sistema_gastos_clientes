package com.codepuppeteer.sistema_gastos_clientes.repository;

import com.codepuppeteer.sistema_gastos_clientes.entity.Auditoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuditoriaRepository extends JpaRepository<Auditoria, Long> {
    List<Auditoria> findByUsuarioIdOrderByFechaEventoDesc(Long usuarioId);
}
