package org.task.gfl_final.controllers.view;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.task.gfl_final.rental.RentalService;
import org.task.gfl_final.rental.dto.RentalPageDto;
import org.task.gfl_final.rental.dto.RentalDateUpdateDto;

import java.math.BigDecimal;
import java.time.LocalDate;


@Controller
@RequestMapping
@AllArgsConstructor
public class RentalViewController {
    private RentalService rentalService;
    @GetMapping("/check-in")
    public String checkIn() {
        return "check-in";
    }

    @GetMapping("/check-out")
    public String checkOut(Model model, @PageableDefault(sort = "id", size = 5) Pageable pageable) {
        model.addAttribute("rentals", rentalService.getRentalsWhichCheckOutToday(pageable).getRentals());
        model.addAttribute("table_caption", "Check Out");
        return "check-out";
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

    @GetMapping("/rental/check-update/{id}")
    public String checkOutRental(@PathVariable Long id, @RequestParam LocalDate oldDate, @RequestParam BigDecimal oldPrice,
                                 Model model) {
        model.addAttribute("rental", rentalService.getRentalById(id));
        model.addAttribute("oldDate", oldDate);
        model.addAttribute("oldPrice", oldPrice);
        return "rental-check-updated";
    }
}
