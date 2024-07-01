package com.mobiauto.backend_interview.repository;

import com.mobiauto.backend_interview.entities.AtendimentoNegociacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtendimentoNegociacaoRepository extends JpaRepository<AtendimentoNegociacao, Long> {
}
