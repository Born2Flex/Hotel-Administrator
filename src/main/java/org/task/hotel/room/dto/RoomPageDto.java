package org.task.hotel.room.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class RoomPageDto {
    private int currentPage;
    private int totalPages;
    private List<RoomDto> rooms;
}
