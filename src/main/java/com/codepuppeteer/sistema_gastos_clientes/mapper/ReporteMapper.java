package com.codepuppeteer.sistema_gastos_clientes.mapper;

import com.codepuppeteer.sistema_gastos_clientes.dto.reporte.*;
import com.codepuppeteer.sistema_gastos_clientes.entity.Reporte;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ReporteMapper {
    ReporteResponse toResponse(Reporte reporte);
    ReporteList toList(Reporte reporte);
    Reporte toEntity(ReporteSave dto);
    void updateFromDto(ReporteUpdate dto, @MappingTarget Reporte entity);
}
