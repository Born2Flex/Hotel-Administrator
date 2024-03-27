package org.task.hotel.guest.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class GuestDto implements Serializable {
    @NotNull(message = "Guest id could not be null")
    Long id;
    @NotBlank(message = "Guest first name couldn't be blank or empty")
    String firstName;
    @NotBlank(message = "Guest last name couldn't be blank or empty")
    String lastName;
    @Pattern(regexp="^[+]?[(]?[0-9]{3}[)]?[-\\s.]?[0-9]{3}[-\\s.]?[0-9]{4,6}$", message = "Phone number should be valid")
    String phoneNumber;
    @Email(message = "Email should be valid")
    String email;
    @NotBlank(message = "Passport data couldn't be blank or empty")
    String passport;
}