package org.task.hotel.rental.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class RentalPageDto {
    @NotNull
    private Integer currentPage;
    @NotNull
    private Integer totalPages;
    @NotNull
    private List<RentalDto> rentals;
}
