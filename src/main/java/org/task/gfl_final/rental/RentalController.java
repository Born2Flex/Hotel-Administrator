package org.task.gfl_final.rental;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.task.gfl_final.rental.dto.RentalDto;
import org.task.gfl_final.rental.dto.RentalRegistrationDto;

@RestController
@RequestMapping("/api/rentals")
@AllArgsConstructor
public class RentalController {
    private RentalService rentalService;
    @PostMapping
    public RentalDto registerRental(@RequestBody RentalRegistrationDto rentalRegistrationDTO) {
        return rentalService.registerRental(rentalRegistrationDTO);
    }
}
