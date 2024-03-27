package org.task.hotel.guest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    Page<Guest> findByLastNameLikeIgnoreCase(String lastName, Pageable pageable);
    Page<Guest> findByFirstNameIgnoreCase(String firstName, Pageable pageable);
    Page<Guest> findByEmailIgnoreCase(String email, Pageable pageable);
    Page<Guest> findByPhoneNumber(String phoneNumber, Pageable pageable);
    Page<Guest> findByPassport(String passport, Pageable pageable);
}