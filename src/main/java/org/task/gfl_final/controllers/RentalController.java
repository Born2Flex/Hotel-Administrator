package org.task.gfl_final.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/rental")
public class RentalController {

    @GetMapping("")
    public String checkIn() {
        return "register_new";
//        return "guests";
    }
}
