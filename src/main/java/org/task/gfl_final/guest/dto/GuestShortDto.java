package org.task.gfl_final.guest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GuestShortDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String passport;
}
