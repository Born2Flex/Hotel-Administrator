package org.task.gfl_final.rental.dto;

import lombok.Data;
import org.task.gfl_final.guest.GuestEntity;
import org.task.gfl_final.room.Room;

import java.time.LocalDate;

@Data
public class RentalRegistrationDTO {
    private Long roomId;
    private Long guestId;
//    private Room room;
//    private GuestEntity guest;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long totalPrice;
}
