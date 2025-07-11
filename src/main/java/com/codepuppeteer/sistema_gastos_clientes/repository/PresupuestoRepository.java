package com.codepuppeteer.sistema_gastos_clientes.repository;

import com.codepuppeteer.sistema_gastos_clientes.entity.Presupuesto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PresupuestoRepository extends JpaRepository<Presupuesto, Long> {
    List<Presupuesto> findByClienteId(Long clienteId);
    Optional<Presupuesto> findByClienteIdAndCategoriaIdAndMesAndAnio(Long clienteId, Long categoriaId, int mes, int anio);
}
