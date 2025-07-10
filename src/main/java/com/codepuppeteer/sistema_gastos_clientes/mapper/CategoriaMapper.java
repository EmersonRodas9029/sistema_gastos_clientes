package com.codepuppeteer.sistema_gastos_clientes.mapper;

import com.codepuppeteer.sistema_gastos_clientes.dto.categoria.*;
import com.codepuppeteer.sistema_gastos_clientes.entity.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
    CategoriaResponse toResponse(Categoria categoria);
    CategoriaList toList(Categoria categoria);
    Categoria toEntity(CategoriaSave dto);
    void updateFromDto(CategoriaUpdate dto, @MappingTarget Categoria entity);
}
