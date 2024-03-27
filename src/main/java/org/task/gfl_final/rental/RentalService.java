package org.task.gfl_final.rental;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.task.gfl_final.rental.dto.RentalDateUpdateDto;
import org.task.gfl_final.rental.dto.RentalDto;
import org.task.gfl_final.rental.dto.RentalPageDto;
import org.task.gfl_final.rental.dto.RentalRegistrationDto;
import org.task.gfl_final.room.Room;
import org.task.gfl_final.room.RoomRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * Service for managing rentals.
 */
@Service
@AllArgsConstructor
public class RentalService {
    private RentalRepository rentalRepository;
    private RoomRepository roomRepository;
    private ModelMapper modelMapper;

    /**
     * Registers a new rental.
     *
     * @param rentalRegistrationDTO the data transfer object containing the rental's information
     * @return the registered rental's information
     */
    public RentalDto registerRental(RentalRegistrationDto rentalRegistrationDTO) {
        Rental rental = modelMapper.map(rentalRegistrationDTO, Rental.class);
        rental.setTotalPrice(calculateTotalPrice(rental.getRoom(), rental.getCheckInDate(), rental.getCheckOutDate()));
        rental.getRoom().setIsAvailable(false);
        roomRepository.save(rental.getRoom());
        return modelMapper.map(rentalRepository.save(rental), RentalDto.class);
    }

    /**
     * Updates a rental's information.
     *
     * @param id        the id of the rental to update
     * @param rentalDTO the data transfer object containing the updated information
     * @return the updated rental's information
     */
    public RentalDto updateRental(Long id, RentalDateUpdateDto rentalDTO) {
        Rental rental = rentalRepository.findById(id).orElseThrow(() -> new RuntimeException("Rental not found"));
        rental.setCheckOutDate(rentalDTO.getCheckOutDate());
        rental.setTotalPrice(calculateTotalPrice(rental.getRoom(), rental.getCheckInDate(), rental.getCheckOutDate()));
        return modelMapper.map(rentalRepository.save(rental), RentalDto.class);
    }

    /**
     * Retrieves a rental by its id.
     *
     * @param id the id of the rental to retrieve
     * @return the rental's information
     */
    public RentalDto getRentalById(Long id) {
        Rental rental = rentalRepository.findById(id).orElseThrow(() -> new RuntimeException("Rental not found"));
        return modelMapper.map(rental, RentalDto.class);
    }

    /**
     * Retrieves all current rentals with pagination.
     *
     * @param pageable the pagination information
     * @return a page of current rentals
     */
    public RentalPageDto getCurrentRentals(Pageable pageable) {
        Page<Rental> page = rentalRepository.findCurrentRentals(pageable);
        List<RentalDto> rentals = page.getContent().stream()
                .map(rental -> modelMapper.map(rental, RentalDto.class))
                .toList();
        return new RentalPageDto(pageable.getPageNumber(), page.getTotalPages(), rentals);
    }

    /**
     * Retrieves all rentals which check out today with pagination.
     *
     * @param pageable the pagination information
     * @return a page of rentals which check out today
     */
    public RentalPageDto getRentalsWhichCheckOutToday(Pageable pageable) {
        Page<Rental> page = rentalRepository.findRentalsWhichCheckOutToday(pageable);
        List<RentalDto> rentals = page.stream()
                .map(rental -> modelMapper.map(rental, RentalDto.class))
                .toList();
        return new RentalPageDto(pageable.getPageNumber(), page.getTotalPages(), rentals);
    }

    /**
     * Checks out multiple rentals.
     *
     * @param rentalIds the ids of the rentals to check out
     * @return a list of checked out rentals' information
     */
    public List<RentalDto> checkOutRentals(List<Long> rentalIds) {
        return rentalIds.stream()
                .map(this::checkOutRental)
                .toList();
    }

    /**
     * Checks out a single rental.
     *
     * @param id the id of the rental to check out
     * @return the checked out rental's information
     */
    public RentalDto checkOutRental(Long id) {
        Rental rental = rentalRepository.findById(id).orElseThrow(() -> new RuntimeException("Rental not found"));
        rental.getRoom().setIsAvailable(true);
        roomRepository.save(rental.getRoom());
        return modelMapper.map(rental, RentalDto.class);
    }

    /**
     * Calculates the total price for a rental.
     *
     * @param room         the room being rented
     * @param checkInDate  the check-in date
     * @param checkOutDate the check-out date
     * @return the total price for the rental
     */
    private BigDecimal calculateTotalPrice(Room room, LocalDate checkInDate, LocalDate checkOutDate) {
        long rentDays = ChronoUnit.DAYS.between(checkInDate, checkOutDate);
        return room.getPrice().multiply(BigDecimal.valueOf(rentDays));
    }
}