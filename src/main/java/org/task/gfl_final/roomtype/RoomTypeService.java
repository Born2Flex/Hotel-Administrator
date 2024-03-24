package org.task.gfl_final.roomtype;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomTypeService {
    private RoomTypeRepository roomTypeRepository;

    public List<RoomType> getRoomTypes() {
        return roomTypeRepository.findAll();
    }

}
