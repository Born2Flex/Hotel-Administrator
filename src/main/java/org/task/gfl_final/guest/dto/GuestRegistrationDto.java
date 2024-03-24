package org.task.gfl_final.guest.dto;

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
public class GuestRegistrationDto {
    @NotBlank(message = "Guest first name couldn't be blank or empty")
    private String firstName;
    @NotBlank(message = "Guest last name couldn't be blank or empty")
    private String lastName;
    @Pattern(regexp="(^$|\\d{10})")
    private String phoneNumber;
    @Email(message = "Email should be valid")
    private String email;
    @NotBlank(message = "Passport data couldn't be blank or empty")
    private String passport;
}
