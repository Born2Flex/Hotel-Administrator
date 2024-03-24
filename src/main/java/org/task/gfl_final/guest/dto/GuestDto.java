package org.task.gfl_final.guest.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

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
    @Pattern(regexp="(^$|\\d{10})")
    String phoneNumber;
    @Email(message = "Email should be valid")
    String email;
    @NotBlank(message = "Passport data couldn't be blank or empty")
    String passport;
}