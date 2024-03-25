package org.task.gfl_final.guest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    List<Guest> findByLastNameLikeIgnoreCase(String lastName);

    @Query("SELECT g FROM Guest g WHERE EXISTS " +
            "(SELECT r FROM Rental r WHERE r.guest.id = g.id AND r.endDate >= CURRENT_DATE)")
    Page<Guest> findCurrentGuests(Pageable pageable);

    List<Guest> findByFirstNameIgnoreCase(String firstName);

    Guest findByPhoneNumber(String phoneNumber);

    Guest findByEmail(String email);

    Guest findByPassport(String passport);
}