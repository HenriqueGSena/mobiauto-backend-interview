package com.mobiauto.backend_interview.repository;

import com.mobiauto.backend_interview.entities.Revenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevendaRepository extends JpaRepository<Revenda, Long> {
    boolean existsByCnpj(String cnpj);
}
