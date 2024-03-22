package org.task.gfl_final.dto;

import lombok.Data;

@Data
public class GuestDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String passport;
}
