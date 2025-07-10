package com.codepuppeteer.sistema_gastos_clientes.mapper;

import com.codepuppeteer.sistema_gastos_clientes.dto.cuenta.*;
import com.codepuppeteer.sistema_gastos_clientes.entity.CuentaBancaria;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CuentaBancariaMapper {
    CuentaBancariaResponse toResponse(CuentaBancaria cuentaBancaria);
    CuentaBancariaList toList(CuentaBancaria cuentaBancaria);
    CuentaBancaria toEntity(CuentaBancariaSave dto);
    void updateFromDto(CuentaBancariaUpdate dto, @MappingTarget CuentaBancaria entity);
}
