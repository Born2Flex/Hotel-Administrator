package org.task.hotel.room;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.task.hotel.room.dto.RoomDto;

import java.util.List;

/**
 * REST Controller for handling requests related to rooms.
 */
@RestController
@RequestMapping("/api/rooms")
@AllArgsConstructor
public class RoomController {
    private RoomService roomService;

    /**
     * Handles GET requests to retrieve available rooms by type id.
     *
     * @param type      the type id of the rooms to retrieve
     * @param available the availability status of the rooms to retrieve
     * @return a list of rooms that match the given type id and availability status
     */
    @GetMapping
    public List<RoomDto> getAvailableRoomsByTypeId(@RequestParam long type, @RequestParam boolean available) {
        return roomService.getRoomsByTypeAndAvailability(type, available);
    }
}