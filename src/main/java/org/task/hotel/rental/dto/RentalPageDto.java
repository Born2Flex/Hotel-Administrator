package org.task.hotel.rental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class RentalPageDto {
    private Integer currentPage;
    private Integer totalPages;
    private List<RentalDto> rentals;
}
