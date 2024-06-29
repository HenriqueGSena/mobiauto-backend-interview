package com.mobiauto.backend_interview.repository;

import com.mobiauto.backend_interview.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
