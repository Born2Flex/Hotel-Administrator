package org.task.gfl_final.guest;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    List<Guest> findByLastNameLikeIgnoreCase(String lastName);

//    List<GuestEntity> findByFirstNameIgnoreCase(String firstName);
//
//    GuestEntity findByPhoneNumber(String phoneNumber);
//
//    GuestEntity findByEmail(String email);
//
//    GuestEntity findByPassport(String passport);
}