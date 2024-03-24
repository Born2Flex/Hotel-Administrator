package org.task.gfl_final.controllers.view;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.task.gfl_final.guest.GuestService;

@Controller
@RequestMapping("/hotel-guests")
@AllArgsConstructor
public class GuestsViewController {
    private GuestService guestService;
    @GetMapping
    public String showAllGuests(Model model) {
        model.addAttribute("guests", guestService.getAllGuests());
        return "hotel-guests";
    }

    @GetMapping("/current")
    public String showCurrentGuests(Model model) {
        model.addAttribute("guests", guestService.getCurrentGuests());
        return "hotel-guests";
    }
}
