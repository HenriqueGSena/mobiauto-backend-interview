package com.mobiauto.backend_interview.repository;

import com.mobiauto.backend_interview.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, Long> {

    UserDetails findByNome(String nome);
}
