package com.mobiauto.backend_interview.repository;

import com.mobiauto.backend_interview.entities.Veiculos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculosRepository extends JpaRepository<Veiculos, Long> {
}
