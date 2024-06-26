package com.mobiauto.backend_interview.controller;

import com.mobiauto.backend_interview.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/{usuarioId}/revendas/{revendaId}")
    public void associarUsuarioComRevenda(@PathVariable Long usuarioId, @PathVariable Long revendaId) {
        usuarioService.associarUsuarioComRevenda(usuarioId, revendaId);
    }
}
