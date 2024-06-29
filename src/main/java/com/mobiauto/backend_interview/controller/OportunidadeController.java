package com.mobiauto.backend_interview.controller;

import com.mobiauto.backend_interview.dto.OportunidadeDTO;
import com.mobiauto.backend_interview.entities.Oportunidade;
import com.mobiauto.backend_interview.repository.OportunidadeRepository;
import com.mobiauto.backend_interview.service.OportunidadeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/oportunidade")
public class OportunidadeController {

    @Autowired
    private OportunidadeService oportunidadeService;

    @Autowired
    private OportunidadeRepository oportunidadeRepository;

    @PostMapping("/criar")
    public ResponseEntity criarOportunidade(@RequestBody @Valid OportunidadeDTO body) {
        Oportunidade newOportunidade = new Oportunidade(body);
        this.oportunidadeRepository.save(newOportunidade);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/listar")
    public ResponseEntity<List<OportunidadeDTO>> listarTodasOpotunidades() {
        return ResponseEntity.ok(this.oportunidadeService.listaOportunidades());
    }
}
