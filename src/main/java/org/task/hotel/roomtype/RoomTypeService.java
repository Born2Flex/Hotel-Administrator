package org.task.hotel.roomtype;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.task.hotel.roomtype.dto.RoomTypeDto;

import java.util.List;

/**
 * Service for managing room types.
 */
@Service
@AllArgsConstructor
public class RoomTypeService {
    private RoomTypeRepository roomTypeRepository;
    private final ModelMapper modelMapper;

    /**
     * Retrieves all room types.
     *
     * @return a list of all room types
     */
    public List<RoomTypeDto> getRoomTypes() {
        return roomTypeRepository.findAll().stream()
                .map(element -> modelMapper.map(element, RoomTypeDto.class)).toList();
    }
}