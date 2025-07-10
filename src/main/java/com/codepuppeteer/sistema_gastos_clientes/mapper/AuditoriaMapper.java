package com.codepuppeteer.sistema_gastos_clientes.mapper;

import com.codepuppeteer.sistema_gastos_clientes.dto.auditoria.*;
import com.codepuppeteer.sistema_gastos_clientes.entity.Auditoria;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AuditoriaMapper {
    AuditoriaResponse toResponse(Auditoria auditoria);
    AuditoriaList toList(Auditoria auditoria);
}
