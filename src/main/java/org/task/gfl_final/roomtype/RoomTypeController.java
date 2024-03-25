package org.task.gfl_final.roomtype;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.task.gfl_final.roomtype.dto.RoomTypeDto;

import java.util.List;

@RestController
@RequestMapping("/api/room-types")
@AllArgsConstructor
public class RoomTypeController {
    private RoomTypeService roomTypeService;
    @GetMapping
    public List<RoomTypeDto> getRoomTypes() {
        List<RoomTypeDto> roomTypes = roomTypeService.getRoomTypes();
        System.out.println(roomTypes);
        return roomTypes;
    }

}
