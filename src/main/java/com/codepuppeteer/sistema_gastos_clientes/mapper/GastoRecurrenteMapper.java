package com.codepuppeteer.sistema_gastos_clientes.mapper;

import com.codepuppeteer.sistema_gastos_clientes.dto.gastorecurrente.*;
import com.codepuppeteer.sistema_gastos_clientes.entity.GastoRecurrente;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface GastoRecurrenteMapper {
    GastoRecurrenteResponse toResponse(GastoRecurrente gastoRecurrente);
    GastoRecurrenteList toList(GastoRecurrente gastoRecurrente);
    GastoRecurrente toEntity(GastoRecurrenteSave dto);
    void updateFromDto(GastoRecurrenteUpdate dto, @MappingTarget GastoRecurrente entity);
}
