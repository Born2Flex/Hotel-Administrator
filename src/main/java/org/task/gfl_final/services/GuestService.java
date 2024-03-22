package org.task.gfl_final.services;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.task.gfl_final.dto.GuestDTO;
import org.task.gfl_final.dto.GuestRegistrationDTO;
import org.task.gfl_final.entities.GuestEntity;
import org.task.gfl_final.repositories.GuestRepository;

@Service
@AllArgsConstructor
public class GuestService {
    private GuestRepository guestRepository;
    private ModelMapper mapper;

    public GuestDTO registerGuest(GuestRegistrationDTO dto) {
        GuestEntity entity = guestRepository.save(mapper.map(dto, GuestEntity.class));
        return mapper.map(entity, GuestDTO.class);
    }
}
