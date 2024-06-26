package com.mobiauto.backend_interview.repository;

import com.mobiauto.backend_interview.entities.UsuarioRevenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRevendaRepository extends JpaRepository<UsuarioRevenda, Long> {
}
