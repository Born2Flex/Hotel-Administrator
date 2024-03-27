package org.task.gfl_final.controllers.view;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.task.gfl_final.guest.GuestSearchService;
import org.task.gfl_final.guest.GuestService;
import org.task.gfl_final.guest.dto.GuestPageDto;

/**
 * View controller for handling requests related to hotel guests.
 */
@Controller
@RequestMapping("/hotel-guests")
@AllArgsConstructor
public class GuestsViewController {
    private GuestService guestService;
    private GuestSearchService searchService;

    /**
     * Handles GET requests to show all registered guests.
     *
     * @param model    the model to add attributes to for rendering in the view
     * @param pageable the pagination information
     * @return view to render
     */
    @GetMapping
    public String showAllGuests(Model model, @PageableDefault(sort = "id", size = 5) Pageable pageable) {
        GuestPageDto page = guestService.getAllGuests(pageable);
        setModelAttributes(model, page);
        model.addAttribute("table_caption", "All Registered Guests");
        model.addAttribute("url", "/hotel-guests");
        return "hotel-guests";
    }

    /**
     * Handles GET requests to search for guests based on given criteria.
     *
     * @param model    the model to add attributes to for rendering in the view
     * @param criteria the search criteria
     * @param value    the value to search for
     * @param pageable the pagination information
     * @return view to render
     */
    @GetMapping("/search")
    public String searchGuests(Model model, @RequestParam String criteria, @RequestParam String value,
                               @PageableDefault(sort = "id", size = 5) Pageable pageable) {
        GuestPageDto page = searchService.search(criteria, value, pageable);
        setModelAttributes(model, page);
        model.addAttribute("table_caption", "Search result: " + "'" + value + "'");
        model.addAttribute("url", "/hotel-guests/search?criteria=" + criteria + "&value=" + value);
        return "hotel-guests";
    }

    /**
     * Sets common model attributes for rendering guest pages.
     *
     * @param model the model to add attributes to
     * @param page  the page of guests to add to the model
     */
    private void setModelAttributes(Model model, GuestPageDto page) {
        model.addAttribute("guests", page.getGuests());
        model.addAttribute("currentPage", page.getCurrentPage());
        model.addAttribute("totalPages", page.getTotalPages());
    }
}
