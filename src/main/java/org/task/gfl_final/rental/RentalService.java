package org.task.gfl_final.rental;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.task.gfl_final.rental.dto.RentalDto;
import org.task.gfl_final.rental.dto.RentalRegistrationDto;
import org.task.gfl_final.room.RoomRepository;

@Service
@AllArgsConstructor
public class RentalService {
    private RentalRepository rentalRepository;
    private RoomRepository roomRepository;
    private ModelMapper modelMapper;

    public RentalDto registerRental(RentalRegistrationDto rentalRegistrationDTO) {
        Rental rental = rentalRepository.save(modelMapper.map(rentalRegistrationDTO, Rental.class));
        rental.getRoom().setIsAvailable(false);
        roomRepository.save(rental.getRoom());
        return modelMapper.map(rental, RentalDto.class);
    }
}
