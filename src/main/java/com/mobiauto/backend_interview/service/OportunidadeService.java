package com.mobiauto.backend_interview.service;

import com.mobiauto.backend_interview.dto.OportunidadeDTO;
import com.mobiauto.backend_interview.repository.OportunidadeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OportunidadeService {

    @Autowired
    private OportunidadeRepository oportunidadeRepository;

    @Transactional
    public List<OportunidadeDTO> listaOportunidades() {
        return oportunidadeRepository.findAll().stream()
                .map(OportunidadeDTO::new)
                .collect(Collectors.toList());
    }
}
