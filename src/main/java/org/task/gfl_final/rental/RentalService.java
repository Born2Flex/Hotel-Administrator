package org.task.gfl_final.rental;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.task.gfl_final.rental.dto.RentalDto;
import org.task.gfl_final.rental.dto.RentalPageDto;
import org.task.gfl_final.rental.dto.RentalRegistrationDto;
import org.task.gfl_final.rental.dto.RentalUpdateDto;
import org.task.gfl_final.room.Room;
import org.task.gfl_final.room.RoomRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@AllArgsConstructor
public class RentalService {
    private RentalRepository rentalRepository;
    private RoomRepository roomRepository;
    private ModelMapper modelMapper;

    public RentalDto registerRental(RentalRegistrationDto rentalRegistrationDTO) {
        Rental rental = modelMapper.map(rentalRegistrationDTO, Rental.class);
        rental.setTotalPrice(calculateTotalPrice(rental.getRoom(), rental.getCheckInDate(), rental.getCheckOutDate()));
        rental.getRoom().setIsAvailable(false);
        roomRepository.save(rental.getRoom());
        return modelMapper.map(rentalRepository.save(rental), RentalDto.class);
    }

    public RentalDto updateRental(Long id, RentalUpdateDto rentalDTO) {
        Rental rental = rentalRepository.findById(id).orElseThrow(() -> new RuntimeException("Rental not found"));
        rental.setCheckOutDate(rentalDTO.getCheckOutDate());
        rental.setTotalPrice(calculateTotalPrice(rental.getRoom(), rental.getCheckInDate(), rental.getCheckOutDate()));
        return modelMapper.map(rentalRepository.save(rental), RentalDto.class);
    }

    //TODO Custom exception
    public RentalDto getRentalById(Long id) {
        Rental rental = rentalRepository.findById(id).orElseThrow(() -> new RuntimeException("Rental not found"));
        return modelMapper.map(rental, RentalDto.class);
    }

    public RentalPageDto getCurrentRentals(Pageable pageable) {
        Page<Rental> page = rentalRepository.findCurrentRentals(pageable);
        List<RentalDto> rentals = rentalRepository.findCurrentRentals(pageable).stream()
                .map(rental -> modelMapper.map(rental, RentalDto.class))
                .toList();
        return new RentalPageDto(pageable.getPageNumber(), page.getTotalPages(), rentals);
    }

    private BigDecimal calculateTotalPrice(Room room, LocalDate checkInDate, LocalDate checkOutDate) {
        long rentDays = ChronoUnit.DAYS.between(checkInDate, checkOutDate);
        return room.getPrice().multiply(BigDecimal.valueOf(rentDays));
    }
}
