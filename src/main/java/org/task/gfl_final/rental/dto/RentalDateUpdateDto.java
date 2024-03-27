package org.task.gfl_final.rental.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RentalDateUpdateDto {
    private Long id;
    private LocalDate checkOutDate;
}
