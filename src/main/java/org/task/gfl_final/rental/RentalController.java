package org.task.gfl_final.rental;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import org.task.gfl_final.rental.dto.RentalDto;
import org.task.gfl_final.rental.dto.RentalRegistrationDto;
import org.task.gfl_final.rental.dto.RentalUpdateDto;

@RestController
@RequestMapping("/api/rentals")
@AllArgsConstructor
public class RentalController {
    private RentalService rentalService;
    @PostMapping
    public RentalDto registerRental(@RequestBody RentalRegistrationDto rentalRegistrationDTO) {
        return rentalService.registerRental(rentalRegistrationDTO);
    }

    @PutMapping("/{id}")
    public RentalDto updateRental(@PathVariable Long id, @RequestBody RentalUpdateDto rentalDTO) {
        return rentalService.updateRental(id, rentalDTO);
    }
}
