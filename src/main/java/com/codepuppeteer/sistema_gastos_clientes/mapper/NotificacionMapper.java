package com.codepuppeteer.sistema_gastos_clientes.mapper;

import com.codepuppeteer.sistema_gastos_clientes.dto.notificacion.*;
import com.codepuppeteer.sistema_gastos_clientes.entity.Notificacion;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface NotificacionMapper {
    NotificacionResponse toResponse(Notificacion notificacion);
    NotificacionList toList(Notificacion notificacion);
    Notificacion toEntity(NotificacionSave dto);
    void updateFromDto(NotificacionUpdate dto, @MappingTarget Notificacion entity);
}
