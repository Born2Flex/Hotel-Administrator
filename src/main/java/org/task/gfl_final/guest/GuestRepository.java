package org.task.gfl_final.guest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    @Query("SELECT g FROM Guest g WHERE EXISTS " +
            "(SELECT r FROM Rental r WHERE r.guest.id = g.id AND r.checkInDate <= CURRENT_DATE AND r.checkOutDate >= CURRENT_DATE)")
    Page<Guest> findCurrentGuests(Pageable pageable);

    Page<Guest> findByLastNameLikeIgnoreCase(String lastName, Pageable pageable);
    Page<Guest> findByFirstNameIgnoreCase(String firstName, Pageable pageable);
    Page<Guest> findByEmailIgnoreCase(String email, Pageable pageable);
    Page<Guest> findByPhoneNumber(String phoneNumber, Pageable pageable);
    Page<Guest> findByPassport(String passport, Pageable pageable);
}