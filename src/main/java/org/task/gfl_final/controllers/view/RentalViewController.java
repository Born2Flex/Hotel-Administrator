package org.task.gfl_final.controllers.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/check-in")
public class RentalViewController {

    @GetMapping()
    public String checkIn() {
        return "check-in";
//        return "register_new";
//        return "guests";
    }
}
