package com.codepuppeteer.sistema_gastos_clientes.service.impl;

import com.codepuppeteer.sistema_gastos_clientes.dto.DtoConfiguracionRequest;
import com.codepuppeteer.sistema_gastos_clientes.dto.DtoConfiguracionResponse;
import com.codepuppeteer.sistema_gastos_clientes.entity.Configuracion;
import com.codepuppeteer.sistema_gastos_clientes.repository.ConfiguracionRepository;
import com.codepuppeteer.sistema_gastos_clientes.service.ConfiguracionService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConfiguracionServiceImpl implements ConfiguracionService {

    private final ConfiguracionRepository configuracionRepository;

    public ConfiguracionServiceImpl(ConfiguracionRepository configuracionRepository) {
        this.configuracionRepository = configuracionRepository;
    }

    @Override
    public DtoConfiguracionResponse guardarConfiguracion(DtoConfiguracionRequest dto) {
        Configuracion config = configuracionRepository.findById(1L).orElse(new Configuracion());
        config.setId(1L);
        config.setNombreEstudio(dto.nombreEstudio());
        config.setLogo(dto.logo());
        configuracionRepository.save(config);

        return new DtoConfiguracionResponse(
                config.getId(),
                config.getNombreEstudio(),
                config.getLogo()
        );
    }

    @Override
    public DtoConfiguracionResponse obtenerConfiguracion() {
        Optional<Configuracion> configOpt = configuracionRepository.findById(1L);
        if (configOpt.isEmpty()) {
            return new DtoConfiguracionResponse(null, null, null);
        }

        Configuracion config = configOpt.get();
        return new DtoConfiguracionResponse(
                config.getId(),
                config.getNombreEstudio(),
                config.getLogo()
        );
    }
}
