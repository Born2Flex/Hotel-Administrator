package org.task.hotel.guest.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GuestRegistrationDto {
    @NotBlank(message = "Guest first name couldn't be blank or empty")
    private String firstName;
    @NotBlank(message = "Guest last name couldn't be blank or empty")
    private String lastName;
    @Pattern(regexp="^[+]?[(]?[0-9]{3}[)]?[-\\s.]?[0-9]{3}[-\\s.]?[0-9]{4,6}$", message = "Phone number should be valid")
    private String phoneNumber;
    @Email(message = "Email should be valid")
    private String email;
    @NotBlank(message = "Passport data couldn't be blank or empty")
    private String passport;
}
