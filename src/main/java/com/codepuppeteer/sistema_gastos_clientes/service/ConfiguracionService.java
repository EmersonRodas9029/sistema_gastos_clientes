package com.codepuppeteer.sistema_gastos_clientes.service;

import com.codepuppeteer.sistema_gastos_clientes.dto.DtoConfiguracionRequest;
import com.codepuppeteer.sistema_gastos_clientes.dto.DtoConfiguracionResponse;

public interface ConfiguracionService {

    DtoConfiguracionResponse guardarConfiguracion(DtoConfiguracionRequest dto);

    DtoConfiguracionResponse obtenerConfiguracion();

}
