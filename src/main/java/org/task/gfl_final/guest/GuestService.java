package org.task.gfl_final.guest;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.task.gfl_final.guest.dto.GuestDto;
import org.task.gfl_final.guest.dto.GuestPageDto;
import org.task.gfl_final.guest.dto.GuestRegistrationDto;

import java.util.List;

@Service
@AllArgsConstructor
public class GuestService {
    private GuestRepository guestRepository;
    private ModelMapper mapper;

    public GuestDto registerGuest(GuestRegistrationDto dto) {
        Guest entity = guestRepository.save(mapper.map(dto, Guest.class));
        return mapper.map(entity, GuestDto.class);
    }

    public GuestDto updateGuest(Long id, GuestDto dto) {
        Guest entity = guestRepository.findById(id).orElseThrow();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setEmail(dto.getEmail());
        entity.setPassport(dto.getPassport());
        return mapper.map(guestRepository.save(entity), GuestDto.class);
    }

    public void deleteGuest(Long id) {
        guestRepository.deleteById(id);
    }

    public List<GuestDto> getAllGuests() {
        return guestRepository.findAll().stream()
                .map(guest -> mapper.map(guest, GuestDto.class)).toList();
    }

    public GuestPageDto getAllGuests(Pageable pageable) {
        Page<Guest> page = guestRepository.findAll(pageable);
        List<GuestDto> guests = page.stream()
                .map(guest -> mapper.map(guest, GuestDto.class)).toList();

        return new GuestPageDto(pageable.getPageNumber(), page.getTotalPages(), guests);
    }

    public GuestPageDto getCurrentGuests(Pageable pageable) {
        Page<Guest> page = guestRepository.findCurrentGuests(pageable);
        List<GuestDto> guests = page.stream()
                .map(guest -> mapper.map(guest, GuestDto.class)).toList();
        return new GuestPageDto(pageable.getPageNumber(), page.getTotalPages(), guests);
    }
}
