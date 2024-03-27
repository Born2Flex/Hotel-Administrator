package org.task.gfl_final.rental;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import org.task.gfl_final.rental.dto.RentalDto;
import org.task.gfl_final.rental.dto.RentalRegistrationDto;
import org.task.gfl_final.rental.dto.RentalDateUpdateDto;

import java.util.List;

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
    public RentalDto updateRental(@PathVariable Long id, @RequestBody RentalDateUpdateDto rentalDTO) {
        return rentalService.updateRental(id, rentalDTO);
    }

    @PutMapping("/check-out")
    public List<RentalDto> checkOutManyRentals(@RequestBody List<Long> rentalIds) {
        return rentalService.checkOutRentals(rentalIds);
    }

    @PutMapping("/check-out/{id}")
    public RentalDto checkOutRental(@PathVariable Long id) {
        return rentalService.checkOutRental(id);
    }
}