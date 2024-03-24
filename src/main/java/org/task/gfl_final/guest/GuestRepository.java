package org.task.gfl_final.guest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.task.gfl_final.guest.GuestEntity;

import java.util.List;

public interface GuestRepository extends JpaRepository<GuestEntity, Long> {

    List<GuestEntity> findByLastNameLikeIgnoreCase(String lastName);
}