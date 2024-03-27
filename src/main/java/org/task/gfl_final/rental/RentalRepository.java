package org.task.gfl_final.rental;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RentalRepository extends JpaRepository<Rental, Long> {
    /**
     * Query to find all rentals that are currently active
     * @param pageable Pageable object
     * @return Page of Rental objects
     */
    @Query("SELECT r FROM Rental r WHERE r.checkOutDate >= CURRENT_DATE AND EXISTS " +
            "(SELECT m FROM Room m WHERE m.id = r.room.id AND m.isAvailable = false)")
    Page<Rental> findCurrentRentals(Pageable pageable);

    /**
     * Query to find all rentals that are checking out today
     * @param pageable Pageable object
     * @return Page of Rental objects
     */
    @Query("SELECT r FROM Rental r WHERE r.checkOutDate = CURRENT_DATE AND EXISTS " +
            "(SELECT m FROM Room m WHERE m.id = r.room.id AND m.isAvailable = false)")
    Page<Rental> findRentalsWhichCheckOutToday(Pageable pageable);
}