package com.codepuppeteer.sistema_gastos_clientes.mapper;

import com.codepuppeteer.sistema_gastos_clientes.dto.meta.*;
import com.codepuppeteer.sistema_gastos_clientes.entity.MetaFinanciera;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MetaFinancieraMapper {
    MetaFinancieraResponse toResponse(MetaFinanciera metaFinanciera);
    MetaFinancieraList toList(MetaFinanciera metaFinanciera);
    MetaFinanciera toEntity(MetaFinancieraSave dto);
    void updateFromDto(MetaFinancieraUpdate dto, @MappingTarget MetaFinanciera entity);
}
