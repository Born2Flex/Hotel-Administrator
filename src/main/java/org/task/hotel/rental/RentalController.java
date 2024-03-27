package org.task.hotel.rental;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.task.hotel.rental.dto.RentalDateUpdateDto;
import org.task.hotel.rental.dto.RentalDto;
import org.task.hotel.rental.dto.RentalRegistrationDto;

import java.util.List;

/**
 * REST Controller for handling requests related to rentals.
 */
@RestController
@RequestMapping("/api/rentals")
@AllArgsConstructor
public class RentalController {
    private RentalService rentalService;

    /**
     * Handles POST requests to register a new rental.
     *
     * @param rentalRegistrationDTO the data transfer object containing the rental's information
     * @return the registered rental's information
     */
    @PostMapping
    public RentalDto registerRental(@RequestBody RentalRegistrationDto rentalRegistrationDTO) {
        return rentalService.registerRental(rentalRegistrationDTO);
    }

    /**
     * Handles PUT requests to update a rental's information.
     *
     * @param id        the id of the rental to update
     * @param rentalDTO the data transfer object containing the updated information
     * @return the updated rental's information
     */
    @PutMapping("/{id}")
    public RentalDto updateRental(@PathVariable Long id, @RequestBody RentalDateUpdateDto rentalDTO) {
        return rentalService.updateRental(id, rentalDTO);
    }

    /**
     * Handles PUT requests to check out multiple rentals.
     *
     * @param rentalIds the ids of the rentals to check out
     * @return a list of checked out rentals' information
     */
    @PutMapping("/check-out")
    public List<RentalDto> checkOutManyRentals(@RequestBody List<Long> rentalIds) {
        return rentalService.checkOutRentals(rentalIds);
    }

    /**
     * Handles PUT requests to check out a single rental.
     *
     * @param id the id of the rental to check out
     * @return the checked out rental's information
     */
    @PutMapping("/check-out/{id}")
    public RentalDto checkOutRental(@PathVariable Long id) {
        return rentalService.checkOutRental(id);
    }
}