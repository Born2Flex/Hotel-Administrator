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


@RestController
@RequestMapping("/api/guests")
@AllArgsConstructor
public class GuestController {
    private GuestService guestService;
    private GuestSearchService searchService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GuestDto registerGuest(@Valid @RequestBody GuestRegistrationDto dto) {
        return guestService.registerGuest(dto);
    }

    @PutMapping("/{id}")
    public GuestDto updateGuest(@PathVariable Long id, @Valid @RequestBody GuestDto dto) {
        return guestService.updateGuest(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGuest(@PathVariable Long id) {
        guestService.deleteGuest(id);
    }

    @GetMapping
    public List<GuestDto> getAllGuests() {
        return guestService.getAllGuests();
    }

    @GetMapping("/search")
    public List<GuestDto> getGuestsByCriteria(@RequestParam String criteria, @RequestParam String value,
                                              @PageableDefault(sort = "id", size = 20) Pageable pageable) {
        return searchService.search(criteria, value, pageable).getGuests();
    }
}
