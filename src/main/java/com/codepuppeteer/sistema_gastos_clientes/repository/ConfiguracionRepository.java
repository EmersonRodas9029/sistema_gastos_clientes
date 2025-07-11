package com.codepuppeteer.sistema_gastos_clientes.repository;

import com.codepuppeteer.sistema_gastos_clientes.entity.Configuracion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ConfiguracionRepository extends JpaRepository<Configuracion, Long> {
    List<Configuracion> findByClienteId(Long clienteId);
    Optional<Configuracion> findByClienteIdAndClave(Long clienteId, String clave);
    boolean existsByClienteIdAndClave(Long clienteId, String clave);
}
