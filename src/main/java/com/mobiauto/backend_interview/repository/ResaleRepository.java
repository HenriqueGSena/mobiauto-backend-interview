package com.mobiauto.backend_interview.repository;

import com.mobiauto.backend_interview.entities.Resale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResaleRepository extends JpaRepository<Resale, Long> {
}
