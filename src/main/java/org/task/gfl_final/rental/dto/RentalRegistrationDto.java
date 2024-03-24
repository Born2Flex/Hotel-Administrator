package org.task.gfl_final.rental.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class RentalRegistrationDto {
    private Long roomId;
    private Long guestId;
//    private Room room;
//    private GuestEntity guest;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal totalPrice;
}
