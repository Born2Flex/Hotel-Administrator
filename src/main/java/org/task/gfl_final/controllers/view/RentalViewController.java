package org.task.gfl_final.controllers.view;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.task.gfl_final.rental.RentalService;


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
    public String check(@PathVariable Long id, Model model) {
        model.addAttribute("rental", rentalService.getRentalById(id));
        return "rental-check";
    }
}
