package com.mobiauto.backend_interview.service;

import com.mobiauto.backend_interview.dto.UsuarioDTO;
import com.mobiauto.backend_interview.entities.Revenda;
import com.mobiauto.backend_interview.entities.Usuario;
import com.mobiauto.backend_interview.entities.UsuarioRevenda;
import com.mobiauto.backend_interview.repository.RevendaRepository;
import com.mobiauto.backend_interview.repository.UsuarioRevendaRepository;
import com.mobiauto.backend_interview.repository.UsuariosRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private RevendaRepository revendaRepository;

    @Autowired
    private UsuarioRevendaRepository usuarioRevendaRepository;

    public void associarUsuarioComRevenda(Long usuarioId, Long revendaId) {
        Optional<Usuario> usuario = usuariosRepository.findById(usuarioId);
        Optional<Revenda> revenda = revendaRepository.findById(revendaId);

        if (usuario.isPresent() && revenda.isPresent()) {
            UsuarioRevenda usuarioRevenda = new UsuarioRevenda();
            usuarioRevenda.setUsuario(usuario.get());
            usuarioRevenda.setRevenda(revenda.get());
            usuarioRevendaRepository.save(usuarioRevenda);
        } else {
            throw new RuntimeException("Erro ao associar usuario a revenda");
        }
    }

    @Transactional
    public List<UsuarioDTO> listaUsuarios() {
        return usuariosRepository.findAll().stream()
               .map(UsuarioDTO::new)
               .collect(Collectors.toList());
    }

    public UsuarioDTO atualizarUsuarios(Long usuarioId, UsuarioDTO usuarioDTO) {
        Optional<Usuario> usuario = usuariosRepository.findById(usuarioId);
        if (usuario.isPresent()) {
            Usuario usuarioAtualizado = usuario.get();
            usuarioAtualizado.setNome(usuarioDTO.getNome());
            usuarioAtualizado.setEmail(usuarioDTO.getEmail());
            usuarioAtualizado.setSenha(usuarioDTO.getSenha());
            usuarioAtualizado.setCargos(usuarioDTO.getCargos());
            return new UsuarioDTO(usuariosRepository.save(usuarioAtualizado));
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }
}
