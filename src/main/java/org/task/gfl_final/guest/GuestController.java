package org.task.gfl_final.guest;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.task.gfl_final.guest.dto.Long;
import org.task.gfl_final.guest.dto.GuestShortDTO;
import org.task.gfl_final.guest.dto.GuestRegistrationDTO;

import java.util.List;


@RestController
@RequestMapping("/api/guests")
@AllArgsConstructor
public class GuestController {
    private GuestService guestService;

    @GetMapping
    public List<GuestShortDTO> getGuestsBySurname(@RequestParam String surname) {
        System.out.println("surname = " + surname);
        System.out.println(guestService.getGuestsBySurname(surname));
//        return guestService.getGuestsBySurname(surname);
        return List.of(new GuestShortDTO(1L, "John", "Doe", "1234567890"),
                new GuestShortDTO(2L, "Jane", "Doe", "0987654321"));
    }

    @PostMapping
    public Long registerGuest(@Valid @RequestBody GuestRegistrationDTO dto) {
        return guestService.registerGuest(dto);
    }
}
