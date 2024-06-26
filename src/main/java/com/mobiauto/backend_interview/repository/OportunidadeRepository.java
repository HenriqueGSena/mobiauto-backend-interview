package com.mobiauto.backend_interview.repository;

import com.mobiauto.backend_interview.entities.Oportunidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OportunidadeRepository extends JpaRepository<Oportunidade, Long> {
}
