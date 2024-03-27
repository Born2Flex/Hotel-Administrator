package org.task.hotel.guest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GuestPageDto {
    private Integer currentPage;
    private Integer totalPages;
    private List<GuestDto> guests;
}
