package org.task.hotel.room.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.task.hotel.roomtype.dto.RoomTypeDto;

import java.math.BigDecimal;

@Data
public class RoomDto {
    @NotNull
    private Long id;
    @NotNull
    private Integer roomNumber;
    @NotNull
    private RoomTypeDto roomType;
    @NotNull
    private Boolean isAvailable;
    @Positive
    private BigDecimal price;
    @Positive
    private Integer numOfBeds;
}