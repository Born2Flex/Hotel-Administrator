package org.task.gfl_final.room;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.task.gfl_final.room.dto.RoomDto;
import org.task.gfl_final.room.dto.RoomPageDto;

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

    public RoomPageDto getRooms(Pageable pageable) {
        Page<Room> page = roomRepository.findAll(pageable);
        List<RoomDto> rooms = page.getContent().stream()
                .map(room -> modelMapper.map(room, RoomDto.class))
                .toList();
        return new RoomPageDto(pageable.getPageNumber(), page.getTotalPages(), rooms);
    }
}
