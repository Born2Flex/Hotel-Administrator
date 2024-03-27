package org.task.gfl_final.room;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.task.gfl_final.room.dto.RoomDto;
import org.task.gfl_final.room.dto.RoomPageDto;

import java.util.List;

/**
 * Service for managing rooms.
 */
@Service
@AllArgsConstructor
public class RoomService {
    private RoomRepository roomRepository;
    private ModelMapper modelMapper;

    /**
     * Retrieves rooms by their type id and availability status.
     *
     * @param roomTypeId the type id of the rooms to retrieve
     * @param available  the availability status of the rooms to retrieve
     * @return a list of rooms that match the given type id and availability status
     */
    public List<RoomDto> getRoomsByTypeAndAvailability(long roomTypeId, boolean available) {
        return roomRepository.findByRoomType_IdAndIsAvailable(roomTypeId, available).stream()
                .map(room -> modelMapper.map(room, RoomDto.class)).toList();
    }

    /**
     * Retrieves all rooms with pagination.
     *
     * @param pageable the pagination information
     * @return a page of rooms
     */
    public RoomPageDto getRooms(Pageable pageable) {
        Page<Room> page = roomRepository.findAll(pageable);
        List<RoomDto> rooms = page.getContent().stream()
                .map(room -> modelMapper.map(room, RoomDto.class))
                .toList();
        return new RoomPageDto(pageable.getPageNumber(), page.getTotalPages(), rooms);
    }
}