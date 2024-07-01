package com.mobiauto.backend_interview.controller;

import com.mobiauto.backend_interview.dto.VeiculosDTO;
import com.mobiauto.backend_interview.entities.Veiculos;
import com.mobiauto.backend_interview.repository.VeiculosRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/veiculos")
public class VeiculosController {

    @Autowired
    private VeiculosRepository veiculosRepository;

    @PostMapping("/criar")
    public ResponseEntity criarVeiculo(@RequestBody @Valid VeiculosDTO body) {
        Veiculos newVeiculos = new Veiculos(body);
        this.veiculosRepository.save(newVeiculos);
        return ResponseEntity.ok().build();
    }
}
