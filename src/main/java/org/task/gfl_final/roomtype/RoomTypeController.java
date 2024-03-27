package org.task.gfl_final.roomtype;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.task.gfl_final.roomtype.dto.RoomTypeDto;

import java.util.List;

/**
 * REST Controller for handling requests related to room types.
 */
@RestController
@RequestMapping("/api/room-types")
@AllArgsConstructor
public class RoomTypeController {
    private RoomTypeService roomTypeService;

    /**
     * Handles GET requests to retrieve all room types.
     *
     * @return a list of all room types
     */
    @GetMapping
    public List<RoomTypeDto> getRoomTypes() {
        return roomTypeService.getRoomTypes();
    }
}