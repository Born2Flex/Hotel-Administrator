package org.task.gfl_final.room;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByRoomType_IdAndIsAvailable(Long id, Boolean isAvailable);
}