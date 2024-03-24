package org.task.gfl_final.rental.dto;

import lombok.Data;

@Data
public class RentalDTO {
    private Long id;
    private Long roomId;
    private Long guestId;
    private String startDate;
    private String endDate;
    private Long totalPrice;
}
