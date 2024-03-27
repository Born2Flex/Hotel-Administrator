package org.task.gfl_final.guest;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.task.gfl_final.guest.dto.GuestDto;
import org.task.gfl_final.guest.dto.GuestRegistrationDto;

import java.util.List;

/**
 * REST Controller for handling requests related to hotel guests.
 */
@RestController
@RequestMapping("/api/guests")
@AllArgsConstructor
public class GuestController {
    private GuestService guestService;
    private GuestSearchService searchService;

    /**
     * Handles POST requests to register a new guest.
     *
     * @param dto the data transfer object containing the guest's information
     * @return the registered guest's information
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GuestDto registerGuest(@Valid @RequestBody GuestRegistrationDto dto) {
        return guestService.registerGuest(dto);
    }

    /**
     * Handles PUT requests to update a guest's information.
     *
     * @param id  the id of the guest to update
     * @param dto the data transfer object containing the updated information
     * @return the updated guest's information
     */
    @PutMapping("/{id}")
    public GuestDto updateGuest(@PathVariable Long id, @Valid @RequestBody GuestDto dto) {
        return guestService.updateGuest(id, dto);
    }

    /**
     * Handles DELETE requests to delete a guest.
     *
     * @param id the id of the guest to delete
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGuest(@PathVariable Long id) {
        guestService.deleteGuest(id);
    }

    /**
     * Handles GET requests to retrieve all guests.
     *
     * @return a list of all guests
     */
    @GetMapping
    public List<GuestDto> getAllGuests() {
        return guestService.getAllGuests();
    }

    /**
     * Handles GET requests to search for guests based on given criteria.
     *
     * @param criteria the search criteria
     * @param value    the value to search for
     * @param pageable the pagination information
     * @return a list of guests that match the search criteria
     */
    @GetMapping("/search")
    public List<GuestDto> getGuestsByCriteria(@RequestParam String criteria, @RequestParam String value,
                                              @PageableDefault(sort = "id", size = 20) Pageable pageable) {
        return searchService.search(criteria, value, pageable).getGuests();
    }
}