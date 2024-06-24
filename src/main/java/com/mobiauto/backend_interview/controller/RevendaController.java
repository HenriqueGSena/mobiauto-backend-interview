package com.mobiauto.backend_interview.controller;

import com.mobiauto.backend_interview.dto.RevendaDTO;
import com.mobiauto.backend_interview.entities.enums.Cargos;
import com.mobiauto.backend_interview.service.RevendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("revendas")
public class RevendaController {

    @Autowired
    private RevendaService revendaService;

    @PostMapping("/associar-usuario")
    public ResponseEntity associarUsuarioARevenda(@RequestParam String revendaId, @RequestParam String usuarioId, @RequestParam Cargos cargo) {
        revendaService.associarUsuarioARevenda(revendaId, usuarioId, cargo);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/listar-usuarios")
    public ResponseEntity<List<RevendaDTO>> listarRevendasComUsuarios() {
        List<RevendaDTO> revendaDTOList = revendaService.listarRevendasComUsuarios();
        return ResponseEntity.ok(revendaDTOList);
    }
}
