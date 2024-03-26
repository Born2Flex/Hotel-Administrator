package org.task.gfl_final.rental;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RentalRepository extends JpaRepository<Rental, Long> {

    @Query("SELECT r FROM Rental r WHERE r.checkInDate <= CURRENT_DATE AND r.checkOutDate >= CURRENT_DATE")
    Page<Rental> findCurrentRentals(Pageable pageable);
}