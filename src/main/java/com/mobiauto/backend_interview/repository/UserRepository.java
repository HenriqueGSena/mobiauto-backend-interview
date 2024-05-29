package com.mobiauto.backend_interview.repository;

import com.mobiauto.backend_interview.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
