package com.mobiauto.backend_interview.service;

import com.mobiauto.backend_interview.entities.Revenda;
import com.mobiauto.backend_interview.entities.Usuario;
import com.mobiauto.backend_interview.entities.UsuarioRevenda;
import com.mobiauto.backend_interview.repository.RevendaRepository;
import com.mobiauto.backend_interview.repository.UsuarioRevendaRepository;
import com.mobiauto.backend_interview.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
}
