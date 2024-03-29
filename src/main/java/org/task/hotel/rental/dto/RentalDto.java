package org.task.hotel.rental.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.task.hotel.guest.dto.GuestDto;
import org.task.hotel.room.dto.RoomDto;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class RentalDto {
    @NotNull
    private Long id;
    @NotNull
    private RoomDto room;
    @NotNull
    private GuestDto guest;
    @NotNull
    private LocalDate checkInDate;
    @NotNull
    private LocalDate checkOutDate;
    @NotNull
    private BigDecimal totalPrice;
}
