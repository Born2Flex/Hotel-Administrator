package org.task.gfl_final.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.task.gfl_final.entities.GuestEntity;

public interface GuestRepository extends JpaRepository<GuestEntity, Long> {
}