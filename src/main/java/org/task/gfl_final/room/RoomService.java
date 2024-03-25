package org.task.gfl_final.room;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.task.gfl_final.room.dto.RoomDto;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomService {
    private RoomRepository roomRepository;
    private ModelMapper modelMapper;

    public List<RoomDto> getRoomsByTypeAndAvailability(long roomTypeId, boolean available) {
        return roomRepository.findByRoomType_IdAndIsAvailable(roomTypeId, available).stream()
                .map(room -> modelMapper.map(room, RoomDto.class)).toList();
    }
}
