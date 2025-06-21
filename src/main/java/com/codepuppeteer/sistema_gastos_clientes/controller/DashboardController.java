package com.codepuppeteer.sistema_gastos_clientes.controller;

import com.codepuppeteer.sistema_gastos_clientes.dto.DtoUsuarioResponse;
import com.codepuppeteer.sistema_gastos_clientes.service.ClienteService;
import com.codepuppeteer.sistema_gastos_clientes.service.UsuarioService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    private final UsuarioService usuarioService;
    private final ClienteService clienteService;

    public DashboardController(UsuarioService usuarioService, ClienteService clienteService) {
        this.usuarioService = usuarioService;
        this.clienteService = clienteService;
    }

    @GetMapping("/dashboard")
    public String mostrarDashboard(Authentication authentication, Model model) {
        String username = authentication.getName();
        var usuario = usuarioService.obtenerPorUsername(username);
        model.addAttribute("usuario", usuario);

        return switch (usuario.rol()) {
            case "CLIENTE" -> {
                model.addAttribute("cliente", usuario.cliente());
                yield "dashboard_cliente";
            }
            case "CONTADOR" -> {
                model.addAttribute("clientes", clienteService.listarClientes(null));
                yield "dashboard_contador";
            }
            default -> "dashboard_generico";
        };
    }
}
