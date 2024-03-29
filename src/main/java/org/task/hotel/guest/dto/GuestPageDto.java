package org.task.hotel.guest.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GuestPageDto {
    @NotNull
    private Integer currentPage;
    @NotNull
    private Integer totalPages;
    @NotNull
    private List<GuestDto> guests;
}
