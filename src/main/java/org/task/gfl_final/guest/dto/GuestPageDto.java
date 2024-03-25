package org.task.gfl_final.guest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class GuestPageDto {
    private Integer currentPage;
    private Integer totalPages;
    private List<GuestDto> guests;
}
