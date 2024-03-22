package org.task.gfl_final.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GuestRegistrationDTO {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @Pattern(regexp="(^$|\\d{10})")
    private String phoneNumber;
    @Email
    private String email;
    @NotBlank
    private String passport;
}
