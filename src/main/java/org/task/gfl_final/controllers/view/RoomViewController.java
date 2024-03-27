package org.task.gfl_final.controllers.view;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.task.gfl_final.room.RoomService;
import org.task.gfl_final.room.dto.RoomPageDto;

@Controller
@AllArgsConstructor
public class RoomViewController {
    private RoomService roomService;
    @RequestMapping("/rooms")
    public String showRooms(@PageableDefault(size = 5, sort = "id") Pageable pageable, Model model) {
        RoomPageDto page = roomService.getRooms(pageable);
        model.addAttribute("rooms", page.getRooms());
        model.addAttribute("currentPage", page.getCurrentPage());
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("table_caption", "Hotel rooms");
        model.addAttribute("url", "/rooms");
        return "rooms";
    }
}
