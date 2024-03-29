package org.task.hotel.room.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class RoomPageDto {
    @NotNull
    private Integer currentPage;
    @NotNull
    private Integer totalPages;
    @NotNull
    private List<RoomDto> rooms;
}
