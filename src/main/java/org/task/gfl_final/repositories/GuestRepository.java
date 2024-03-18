package org.task.gfl_final.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.task.gfl_final.entities.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}