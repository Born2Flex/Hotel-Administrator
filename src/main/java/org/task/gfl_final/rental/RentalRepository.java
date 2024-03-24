package org.task.gfl_final.rental;

import org.springframework.data.jpa.repository.JpaRepository;
import org.task.gfl_final.rental.Rental;

public interface RentalRepository extends JpaRepository<Rental, Long> {
}