package com.codepuppeteer.sistema_gastos_clientes.controller;

import com.codepuppeteer.sistema_gastos_clientes.dto.DtoUsuarioRequest;
import com.codepuppeteer.sistema_gastos_clientes.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registro")
public class RegistroController {

    private final UsuarioService usuarioService;

    public RegistroController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new DtoUsuarioRequest(null, null, null, null));
        return "registro";
    }

    @PostMapping
    public String registrarUsuario(@ModelAttribute("usuario") @Valid DtoUsuarioRequest dto) {
        usuarioService.registrarUsuario(dto);
        return "redirect:/login?registrado";
    }
}
