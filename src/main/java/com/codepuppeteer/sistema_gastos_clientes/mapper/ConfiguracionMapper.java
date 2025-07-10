package com.codepuppeteer.sistema_gastos_clientes.mapper;

import com.codepuppeteer.sistema_gastos_clientes.dto.configuracion.*;
import com.codepuppeteer.sistema_gastos_clientes.entity.Configuracion;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ConfiguracionMapper {
    ConfiguracionResponse toResponse(Configuracion configuracion);
    ConfiguracionList toList(Configuracion configuracion);
    Configuracion toEntity(ConfiguracionSave dto);
    void updateFromDto(ConfiguracionUpdate dto, @MappingTarget Configuracion entity);
}
