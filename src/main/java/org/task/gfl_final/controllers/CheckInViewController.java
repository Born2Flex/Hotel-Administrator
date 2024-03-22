package org.task.gfl_final.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/check-in")
public class CheckInViewController {
    @GetMapping()
    public String checkIn() {
        return "register_new";
    }
}
