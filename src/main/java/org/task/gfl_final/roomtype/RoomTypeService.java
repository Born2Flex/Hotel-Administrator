package org.task.gfl_final.roomtype;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.task.gfl_final.roomtype.dto.RoomTypeDto;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomTypeService {
    private RoomTypeRepository roomTypeRepository;
    private final ModelMapper modelMapper;

    public List<RoomTypeDto> getRoomTypes() {
        return roomTypeRepository.findAll().stream()
                .map(element -> modelMapper.map(element, RoomTypeDto.class)).toList();
    }
}
