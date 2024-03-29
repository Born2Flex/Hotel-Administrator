package org.task.hotel.rental.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RentalDateUpdateDto {
    @NotNull
    private Long id;
    @NotNull
    private LocalDate checkOutDate;
}
