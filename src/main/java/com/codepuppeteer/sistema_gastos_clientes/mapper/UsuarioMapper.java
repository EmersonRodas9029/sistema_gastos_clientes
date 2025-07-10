package com.codepuppeteer.sistema_gastos_clientes.mapper;

import com.codepuppeteer.sistema_gastos_clientes.dto.usuario.*;
import com.codepuppeteer.sistema_gastos_clientes.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UsuarioResponse toResponse(Usuario usuario);
    UsuarioList toList(Usuario usuario);
    Usuario toEntity(UsuarioSave dto);
    void updateFromDto(UsuarioUpdate dto, @MappingTarget Usuario entity);
}
