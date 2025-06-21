package com.codepuppeteer.sistema_gastos_clientes.repository;

import com.codepuppeteer.sistema_gastos_clientes.entity.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface GastoRepository extends JpaRepository<Gasto, Long> {

    List<Gasto> findByClienteId(Long clienteId);

    List<Gasto> findByFechaBetween(LocalDate fechaInicio, LocalDate fechaFin);

    List<Gasto> findByCategoriaContainingIgnoreCase(String categoria);

}
