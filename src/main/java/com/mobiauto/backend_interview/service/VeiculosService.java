package com.mobiauto.backend_interview.service;

import com.mobiauto.backend_interview.dto.VeiculosDTO;
import com.mobiauto.backend_interview.repository.VeiculosRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VeiculosService {

    @Autowired
    private VeiculosRepository veiculosRepository;

    @Transactional
    public List<VeiculosDTO> listarVeiculos() {
        return veiculosRepository.findAll().stream()
                .map(VeiculosDTO::new)
                .collect(Collectors.toList());
    }
}
