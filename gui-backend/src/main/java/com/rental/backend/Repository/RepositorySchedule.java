package com.rental.backend.Repository;

import com.rental.backend.Modal.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorySchedule extends JpaRepository<Schedule, String>  {
}
