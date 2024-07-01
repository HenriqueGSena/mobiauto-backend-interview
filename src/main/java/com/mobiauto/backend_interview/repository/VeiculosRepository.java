package com.mobiauto.backend_interview.repository;

import com.mobiauto.backend_interview.entities.Veiculos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculosRepository extends JpaRepository<Veiculos, Long> {
}
