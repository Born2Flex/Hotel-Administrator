package org.task.gfl_final.guest;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.task.gfl_final.guest.dto.GuestShortDTO;
import org.task.gfl_final.guest.dto.GuestRegistrationDTO;

import java.util.List;


@RestController
@RequestMapping("/api/guests")
@AllArgsConstructor
public class GuestController {
    private GuestService guestService;

    @PostMapping
    public GuestShortDTO registerGuest(@Valid @RequestBody GuestRegistrationDTO dto) {
        return guestService.registerGuest(dto);
    }

    //TODO implement different criteria for search
    @GetMapping
    public List<GuestShortDTO> getGuestsByCriteria(@RequestParam String criteria, @RequestParam String value) {
//        System.out.println("Last name = " + lastName);
//        System.out.println(guestService.getGuestsByLastName(lastName));
////        return guestService.getGuestsBySurname(surname);
//        return List.of(new GuestShortDTO(1L, "John", "Doe", "1234567890"),
//                new GuestShortDTO(2L, "Jane", "Doe", "0987654321"));
        return guestService.getGuestsByLastName(value);
    }
}
