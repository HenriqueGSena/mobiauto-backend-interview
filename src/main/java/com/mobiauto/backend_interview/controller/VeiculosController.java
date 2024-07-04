package com.mobiauto.backend_interview.controller;

import com.mobiauto.backend_interview.dto.VeiculosDTO;
import com.mobiauto.backend_interview.entities.Veiculos;
import com.mobiauto.backend_interview.repository.VeiculosRepository;
import com.mobiauto.backend_interview.service.VeiculosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculosController {

    @Autowired
    private VeiculosRepository veiculosRepository;

    @Autowired
    private VeiculosService veiculosService;

    @PostMapping("/criar")
    public ResponseEntity criarVeiculo(@RequestBody @Valid VeiculosDTO body) {
        Veiculos newVeiculos = new Veiculos(body);
        this.veiculosRepository.save(newVeiculos);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/listar")
    public ResponseEntity<List<VeiculosDTO>> listarVeiculos() {
        return ResponseEntity.ok(this.veiculosService.listarVeiculos());
    }
}
