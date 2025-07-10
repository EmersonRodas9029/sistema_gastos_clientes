package com.codepuppeteer.sistema_gastos_clientes.mapper;

import com.codepuppeteer.sistema_gastos_clientes.dto.cliente.*;
import com.codepuppeteer.sistema_gastos_clientes.entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    ClienteResponse toResponse(Cliente cliente);
    ClienteList toList(Cliente cliente);
    Cliente toEntity(ClienteSave dto);
    void updateFromDto(ClienteUpdate dto, @MappingTarget Cliente entity);
}
