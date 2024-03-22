package org.task.gfl_final.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.task.gfl_final.dto.GuestDTO;
import org.task.gfl_final.dto.GuestRegistrationDTO;
import org.task.gfl_final.services.GuestService;


@RestController
@RequestMapping("/guest")
@AllArgsConstructor
public class GuestController {
    private GuestService guestService;
    @PostMapping()
    public GuestDTO registerGuest(@Valid @RequestBody GuestRegistrationDTO dto) {
        return guestService.registerGuest(dto);
    }
}
