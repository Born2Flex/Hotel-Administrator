package org.task.gfl_final.services;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.task.gfl_final.dto.GuestRegistrationDTO;
import org.task.gfl_final.entities.Guest;
import org.task.gfl_final.repositories.GuestRepository;

@Service
@AllArgsConstructor
public class GuestService {
    private GuestRepository guestRepository;
    private ModelMapper mapper;

    public void registerGuest(GuestRegistrationDTO dto) {
        guestRepository.save(mapper.map(dto, Guest.class));
    }
}
