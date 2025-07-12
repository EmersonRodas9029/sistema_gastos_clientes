package com.codepuppeteer.sistema_gastos_clientes.repository;

import com.codepuppeteer.sistema_gastos_clientes.entity.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;


import java.util.List;

public interface GastoRepository extends JpaRepository<Gasto, Long> {
    List<Gasto> findByClienteId(Long clienteId);
    List<Gasto> findByClienteIdAndActivoTrue(Long clienteId);
    List<Gasto> findByClienteIdAndFechaBetweenAndActivoTrue(Long clienteId, LocalDate desde, LocalDate hasta);

}
