package com.mobiauto.backend_interview.service;

import com.mobiauto.backend_interview.dto.RevendaDTO;
import com.mobiauto.backend_interview.dto.UsuarioDTO;
import com.mobiauto.backend_interview.entities.Revenda;
import com.mobiauto.backend_interview.entities.Usuario;
import com.mobiauto.backend_interview.entities.enums.Cargos;
import com.mobiauto.backend_interview.repository.RevendaRepository;
import com.mobiauto.backend_interview.repository.UsuariosRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RevendaService {

    @Autowired
    private RevendaRepository revendaRepository;

    @Autowired
    private UsuariosRepository usuarioRepository;

    @Transactional
    public void associarUsuarioARevenda(String revendaId, String usuarioId, Cargos cargos) {
        Revenda revenda = revendaRepository.findById(revendaId)
                .orElseThrow(() -> new RuntimeException("Revenda não encontrada com id: " + revendaId));

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com id: " + usuarioId));

        usuario.setRevenda(revenda);
        usuario.setCargos(cargos);

        revenda.getUsuarios().add(usuario);
        revendaRepository.save(revenda);
    }

    public List<RevendaDTO> listarRevendasComUsuarios() {
        List<Revenda> revendas = revendaRepository.findAll();

        List<RevendaDTO> revendasComUsuarios = new ArrayList<>();

        for (Revenda revenda : revendas) {
            RevendaDTO dto = new RevendaDTO();
            dto.setId(revenda.getId());
            dto.setNomeSocial(revenda.getNomeSocial());
            List<UsuarioDTO> usuariosDTO = new ArrayList<>();
            for (Usuario usuario : revenda.getUsuarios()) {
                UsuarioDTO usuarioDTO = new UsuarioDTO();
                usuarioDTO.setId(usuario.getId());
                usuarioDTO.setNome(usuario.getNome());
                usuarioDTO.setEmail(usuario.getEmail());
                usuarioDTO.setCargos(usuario.getCargos());
                usuariosDTO.add(usuarioDTO);
            }
            dto.setUsuarios(usuariosDTO);
            revendasComUsuarios.add(dto);
        }

        return revendasComUsuarios;
    }
}

