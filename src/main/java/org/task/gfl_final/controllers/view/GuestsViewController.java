package org.task.gfl_final.controllers.view;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.task.gfl_final.guest.GuestService;
import org.task.gfl_final.guest.dto.GuestPageDto;

@Controller
@RequestMapping("/hotel-guests")
@AllArgsConstructor
public class GuestsViewController {
    private GuestService guestService;
    @GetMapping
    public String showAllGuests(Model model, @PageableDefault(sort = "id", size = 5) Pageable pageable) {
        GuestPageDto page = guestService.getAllGuests(pageable);
        model.addAttribute("guests", page.getGuests());
        model.addAttribute("currentPage", page.getCurrentPage());
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("table_caption", "All guests");
        return "hotel-guests";
    }

    @GetMapping("/current")
    public String showCurrentGuests(Model model, @PageableDefault(sort = "id", size = 5) Pageable pageable) {
        GuestPageDto page = guestService.getCurrentGuests(pageable);
        model.addAttribute("guests", page.getGuests());
        model.addAttribute("currentPage", page.getCurrentPage());
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("table_caption", "Current guests");
        return "current-hotel-guests";
    }
}
