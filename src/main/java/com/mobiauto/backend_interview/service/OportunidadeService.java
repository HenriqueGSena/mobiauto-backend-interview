package com.mobiauto.backend_interview.service;

import com.mobiauto.backend_interview.dto.OportunidadeDTO;
import com.mobiauto.backend_interview.entities.AtendimentoNegociacao;
import com.mobiauto.backend_interview.entities.Oportunidade;
import com.mobiauto.backend_interview.entities.Usuario;
import com.mobiauto.backend_interview.repository.AtendimentoNegociacaoRepository;
import com.mobiauto.backend_interview.repository.OportunidadeRepository;
import com.mobiauto.backend_interview.repository.UsuariosRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OportunidadeService {

    @Autowired
    private OportunidadeRepository oportunidadeRepository;

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private AtendimentoNegociacaoRepository atendimentoNegociacaoRepository;


    @Transactional
    public List<OportunidadeDTO> listaOportunidades() {
        return oportunidadeRepository.findAll().stream()
                .map(OportunidadeDTO::new)
                .collect(Collectors.toList());
    }

    public void associarUsuarioComOportunidade(Long usuarioId, Long oportunidadeId) {
        Optional<Usuario> usuario = usuariosRepository.findById(usuarioId);
        Optional<Oportunidade> oportunidade = oportunidadeRepository.findById(oportunidadeId);

        if (usuario.isPresent() && oportunidade.isPresent()) {
            AtendimentoNegociacao atendimentoNegociacao = new AtendimentoNegociacao();
            atendimentoNegociacao.setUsuario(usuario.get());
            atendimentoNegociacao.setOportunidades(oportunidade.get());
            atendimentoNegociacaoRepository.save(atendimentoNegociacao);
        } else {
            throw new RuntimeException("Erro ao associar usuario a oportunidade");
        }
    }
}
