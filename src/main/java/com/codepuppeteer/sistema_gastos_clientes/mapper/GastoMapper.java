package com.codepuppeteer.sistema_gastos_clientes.mapper;

import com.codepuppeteer.sistema_gastos_clientes.dto.gasto.*;
import com.codepuppeteer.sistema_gastos_clientes.entity.Gasto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface GastoMapper {
    GastoResponse toResponse(Gasto gasto);
    GastoList toList(Gasto gasto);
    Gasto toEntity(GastoSave dto);
    void updateFromDto(GastoUpdate dto, @MappingTarget Gasto entity);
}
