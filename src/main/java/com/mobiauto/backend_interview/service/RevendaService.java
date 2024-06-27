package com.mobiauto.backend_interview.service;

import com.mobiauto.backend_interview.dto.RevendaDTO;
import com.mobiauto.backend_interview.dto.UsuarioDTO;
import com.mobiauto.backend_interview.entities.Revenda;
import com.mobiauto.backend_interview.entities.Usuario;
import com.mobiauto.backend_interview.entities.enums.Cargos;
import com.mobiauto.backend_interview.repository.RevendaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RevendaService {

    @Autowired
    private RevendaRepository revendaRepository;

}

