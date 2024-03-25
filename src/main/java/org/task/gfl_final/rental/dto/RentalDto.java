package org.task.gfl_final.rental.dto;

import lombok.Data;
import org.task.gfl_final.guest.Guest;
import org.task.gfl_final.guest.dto.GuestDto;
import org.task.gfl_final.room.Room;
import org.task.gfl_final.room.dto.RoomDto;

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
