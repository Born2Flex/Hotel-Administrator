package org.task.hotel.rental.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RentalRegistrationDto {
    @NotNull
    private Long roomId;
    @NotNull
    private Long guestId;
    @NotNull
    private LocalDate checkInDate;
    @NotNull
    private LocalDate checkOutDate;
}
