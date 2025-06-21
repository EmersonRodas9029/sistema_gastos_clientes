package com.codepuppeteer.sistema_gastos_clientes.controller;

import com.codepuppeteer.sistema_gastos_clientes.service.ClienteService;
import com.codepuppeteer.sistema_gastos_clientes.service.GastoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;
    private final GastoService gastoService;

    public ClienteController(ClienteService clienteService, GastoService gastoService) {
        this.clienteService = clienteService;
        this.gastoService = gastoService;
    }

    @GetMapping("/{id}")
    public String verDetalleCliente(@PathVariable Long id, Model model) {
        var cliente = clienteService.obtenerClientePorId(id);
        var gastos = gastoService.listarGastosPorCliente(id);

        model.addAttribute("cliente", cliente);
        model.addAttribute("gastos", gastos);
        return "clientes/detalle";
    }
}
