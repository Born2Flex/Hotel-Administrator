package org.task.gfl_final.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.task.gfl_final.entities.Rental;

public interface RentalRepository extends JpaRepository<Rental, Long> {
}