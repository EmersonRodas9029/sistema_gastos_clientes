package com.codepuppeteer.sistema_gastos_clientes.mapper;

import com.codepuppeteer.sistema_gastos_clientes.dto.presupuesto.*;
import com.codepuppeteer.sistema_gastos_clientes.entity.Presupuesto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PresupuestoMapper {
    PresupuestoResponse toResponse(Presupuesto presupuesto);
    PresupuestoList toList(Presupuesto presupuesto);
    Presupuesto toEntity(PresupuestoSave dto);
    void updateFromDto(PresupuestoUpdate dto, @MappingTarget Presupuesto entity);
}
