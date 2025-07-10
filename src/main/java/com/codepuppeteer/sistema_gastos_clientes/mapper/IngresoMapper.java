package com.codepuppeteer.sistema_gastos_clientes.mapper;

import com.codepuppeteer.sistema_gastos_clientes.dto.ingreso.*;
import com.codepuppeteer.sistema_gastos_clientes.entity.Ingreso;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface IngresoMapper {
    IngresoResponse toResponse(Ingreso ingreso);
    IngresoList toList(Ingreso ingreso);
    Ingreso toEntity(IngresoSave dto);
    void updateFromDto(IngresoUpdate dto, @MappingTarget Ingreso entity);
}
