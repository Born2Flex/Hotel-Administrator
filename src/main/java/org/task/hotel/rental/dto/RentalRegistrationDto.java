package org.task.hotel.rental.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RentalRegistrationDto {
    private Long roomId;
    private Long guestId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}
