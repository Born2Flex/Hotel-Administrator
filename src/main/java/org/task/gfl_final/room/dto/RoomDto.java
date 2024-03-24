package org.task.gfl_final.rental.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

@Data
public class RoomDto {
    @NotNull
    Long id;
    @NotNull
    Integer roomNumber;
    @NotNull
    RoomDto roomType;
    @NotNull
    Boolean isAvailable;
}