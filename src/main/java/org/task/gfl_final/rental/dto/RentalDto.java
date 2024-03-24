package org.task.gfl_final.rental.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RentalDto {
    private Long id;
    private Long roomId;
    private Long guestId;
    private String startDate;
    private String endDate;
    private BigDecimal totalPrice;
}
