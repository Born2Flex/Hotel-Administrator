package org.task.gfl_final.controllers.view;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.task.gfl_final.rental.RentalService;
import org.task.gfl_final.rental.dto.RentalPageDto;


@Controller
@RequestMapping
@AllArgsConstructor
public class RentalViewController {
    private RentalService rentalService;
    @GetMapping("/check-in")
    public String checkIn() {
        return "check-in";
    }

    @GetMapping("/rental/check/{id}")
    public String showRentalCheck(@PathVariable Long id, Model model) {
        model.addAttribute("rental", rentalService.getRentalById(id));
        return "rental-check";
    }

    @GetMapping("/current-rentals")
    public String showCurrentRentals(Model model, @PageableDefault(sort = "id", size = 5) Pageable pageable) {
        RentalPageDto page = rentalService.getCurrentRentals(pageable);
        model.addAttribute("rentals", page.getRentals());
        model.addAttribute("currentPage", page.getCurrentPage());
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("table_caption", "Current Rentals");
        model.addAttribute("url", "/current-rentals");
        return "current-rentals";
    }
}
