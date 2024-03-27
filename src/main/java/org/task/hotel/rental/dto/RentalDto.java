package org.task.hotel.rental.dto;

import lombok.Data;
import org.task.hotel.guest.dto.GuestDto;
import org.task.hotel.room.dto.RoomDto;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class RentalDto {
    private Long id;
    private RoomDto room;
    private GuestDto guest;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private BigDecimal totalPrice;
}
