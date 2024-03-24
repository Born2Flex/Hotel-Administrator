package org.task.gfl_final.room;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.task.gfl_final.room.dto.RoomShortDTO;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@AllArgsConstructor
public class RoomController {
    private RoomService roomService;

    @GetMapping
    public List<RoomShortDTO> getAvailableRoomsByTypeId(@RequestParam long type, @RequestParam boolean available) {
        return roomService.getRoomsByTypeAndAvailability(type, available);
    }

}
