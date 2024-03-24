package org.task.gfl_final.room.dto;

import lombok.Data;
import org.task.gfl_final.roomtype.RoomType;

@Data
public class RoomShortDto {
    private Long id;
    private Long roomNumber;
    private Integer numOfBeds;
    private RoomType roomType;
}
