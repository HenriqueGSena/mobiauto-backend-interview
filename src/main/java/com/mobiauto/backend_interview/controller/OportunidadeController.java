package com.mobiauto.backend_interview.controller;

import com.mobiauto.backend_interview.dto.OportunidadeDTO;
import com.mobiauto.backend_interview.entities.Oportunidade;
import com.mobiauto.backend_interview.repository.OportunidadeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oportunidade")
public class OportunidadeController {

    @Autowired
    private OportunidadeRepository oportunidadeRepository;

    @PostMapping("/criar")
    public ResponseEntity criarOportunidade(@RequestBody @Valid OportunidadeDTO body) {
        Oportunidade newOportunidade = new Oportunidade(body);
        this.oportunidadeRepository.save(newOportunidade);
        return ResponseEntity.ok().build();
    }
}
