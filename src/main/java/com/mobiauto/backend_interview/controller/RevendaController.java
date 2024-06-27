package com.mobiauto.backend_interview.controller;

import com.mobiauto.backend_interview.dto.RevendaDTO;
import com.mobiauto.backend_interview.dto.RevendaRequestDTO;
import com.mobiauto.backend_interview.entities.Revenda;
import com.mobiauto.backend_interview.entities.enums.Cargos;
import com.mobiauto.backend_interview.repository.RevendaRepository;
import com.mobiauto.backend_interview.service.RevendaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("revendas")
public class RevendaController {

    @Autowired
    private RevendaService revendaService;

    @Autowired
    private RevendaRepository revendaRepository;

    @PostMapping("/criar")
    public ResponseEntity createRevenda(@RequestBody @Valid RevendaRequestDTO body) {
        if (this.revendaRepository.existsByCnpj(body.cnpj())) {
            return ResponseEntity.badRequest().body("CNPJ já está em uso.");
        }
        Revenda newRevenda = new Revenda(body);
        this.revendaRepository.save(newRevenda);
        return ResponseEntity.ok().build();
    }
}
