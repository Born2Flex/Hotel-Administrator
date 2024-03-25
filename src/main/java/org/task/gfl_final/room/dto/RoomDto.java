package org.task.gfl_final.room.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.task.gfl_final.roomtype.dto.RoomTypeDto;

import java.io.Serializable;
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