package org.task.gfl_final.guest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GuestShortDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String passport;
}
