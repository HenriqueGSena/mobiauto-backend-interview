package com.mobiauto.backend_interview.controller;

import com.mobiauto.backend_interview.dto.UsuarioDTO;
import com.mobiauto.backend_interview.repository.UsuariosRepository;
import com.mobiauto.backend_interview.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private UsuariosRepository usuariosRepository;

    @PostMapping("/{usuarioId}/revendas/{revendaId}")
    public void associarUsuarioComRevenda(@PathVariable Long usuarioId, @PathVariable Long revendaId) {
        usuarioService.associarUsuarioComRevenda(usuarioId, revendaId);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.listaUsuarios());
    }

    @PutMapping("/atualizar/{usuarioId}")
    public ResponseEntity atualizarUsuario(@PathVariable Long usuarioId, @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO usuarioAtualizado = usuarioService.atualizarUsuarios(usuarioId, usuarioDTO);
        return ResponseEntity.ok(usuarioAtualizado);
    }
}
