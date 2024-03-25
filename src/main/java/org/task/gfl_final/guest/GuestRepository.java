package org.task.gfl_final.guest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    @Query("SELECT g FROM Guest g WHERE EXISTS " +
            "(SELECT r FROM Rental r WHERE r.guest.id = g.id AND r.checkOutDate >= CURRENT_DATE)")
    Page<Guest> findCurrentGuests(Pageable pageable);

    List<Guest> findByLastNameLikeIgnoreCase(String lastName);
    List<Guest> findByFirstNameIgnoreCase(String firstName);
    List<Guest> findByEmailIgnoreCase(String email);
    List<Guest> findByPhoneNumber(String phoneNumber);
    List<Guest> findByPassport(String passport);
}