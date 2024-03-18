package org.task.gfl_final.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.task.gfl_final.repositories.RentalRepository;

@Service
@RequestMapping("/rental")
@AllArgsConstructor
public class RentalService {
    private RentalRepository rentalRepository;

    @PostMapping
    public void createRental() {

    }

}
