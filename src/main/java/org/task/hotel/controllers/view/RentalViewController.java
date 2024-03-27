package org.task.hotel.controllers.view;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.task.hotel.rental.RentalService;
import org.task.hotel.rental.dto.RentalPageDto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * View controller for handling requests related to rentals.
 */
@Controller
@RequestMapping
@AllArgsConstructor
public class RentalViewController {
    private RentalService rentalService;
    /**
     * Handles GET requests to check-in.
     *
     * @return the name of the view to render
     */
    @GetMapping("/check-in")
    public String checkIn() {
        return "check-in";
    }

    /**
     * Handles GET requests to check-out.
     *
     * @param model    the model to add attributes to for rendering in the view
     * @param pageable the pagination information
     * @return the name of the view to render
     */
    @GetMapping("/check-out")
    public String checkOut(Model model, @PageableDefault(sort = "id", size = 5) Pageable pageable) {
        model.addAttribute("rentals", rentalService.getRentalsWhichCheckOutToday(pageable).getRentals());
        model.addAttribute("table_caption", "Check Out");
        return "check-out";
    }

    /**
     * Handles GET requests to show rental check.
     *
     * @param id    the id of the rental
     * @param model the model to add attributes to for rendering in the view
     * @return the name of the view to render
     */
    @GetMapping("/rental/check/{id}")
    public String showRentalCheck(@PathVariable Long id, Model model) {
        model.addAttribute("rental", rentalService.getRentalById(id));
        return "rental-check";
    }

    /**
     * Handles GET requests to show current rentals.
     *
     * @param model    the model to add attributes to for rendering in the view
     * @param pageable the pagination information
     * @return the name of the view to render
     */
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

    /**
     * Handles GET requests to check out rental.
     *
     * @param id       the id of the rental
     * @param oldDate  the old date of the rental
     * @param oldPrice the old price of the rental
     * @param model    the model to add attributes to for rendering in the view
     * @return the name of the view to render
     */
    @GetMapping("/rental/check-update/{id}")
    public String checkOutRental(@PathVariable Long id, @RequestParam LocalDate oldDate, @RequestParam BigDecimal oldPrice,
                                 Model model) {
        model.addAttribute("rental", rentalService.getRentalById(id));
        model.addAttribute("oldDate", oldDate);
        model.addAttribute("oldPrice", oldPrice);
        return "rental-check-updated";
    }
}
