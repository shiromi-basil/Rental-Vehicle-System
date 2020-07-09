package com.rental.backend.Repository;

import com.rental.backend.Modal.Motorbike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryMotorbike extends JpaRepository<Motorbike, String> {
}
