package com.rental.backend.Repository;

import com.rental.backend.Modal.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryCar extends JpaRepository<Car, String> {
}
