package org.task.gfl_final.guest;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.task.gfl_final.guest.dto.Long;
import org.task.gfl_final.guest.dto.GuestShortDTO;
import org.task.gfl_final.guest.dto.GuestRegistrationDTO;

import java.util.List;

@Service
@AllArgsConstructor
public class GuestService {
    private GuestRepository guestRepository;
    private ModelMapper mapper;

    public Long registerGuest(GuestRegistrationDTO dto) {
        GuestEntity entity = guestRepository.save(mapper.map(dto, GuestEntity.class));
        return mapper.map(entity, Long.class);
    }

    public List<GuestShortDTO> getGuestsBySurname(String surname) {
        List<GuestShortDTO> guests = guestRepository.findByLastNameLikeIgnoreCase(surname).stream()
                .map(guest -> mapper.map(guest, GuestShortDTO.class)).toList();
        return guests;
    }
}
