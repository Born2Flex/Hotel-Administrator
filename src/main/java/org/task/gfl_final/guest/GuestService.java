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

/**
 * Service for managing hotel guests.
 */
@Service
@AllArgsConstructor
public class GuestService {
    private GuestRepository guestRepository;
    private ModelMapper mapper;

    /**
     * Registers a new guest.
     *
     * @param dto the data transfer object containing the guest's information
     * @return the registered guest's information
     */
    public GuestDto registerGuest(GuestRegistrationDto dto) {
        Guest entity = guestRepository.save(mapper.map(dto, Guest.class));
        return mapper.map(entity, GuestDto.class);
    }

    /**
     * Updates a guest's information.
     *
     * @param id  the id of the guest to update
     * @param dto the data transfer object containing the updated information
     * @return the updated guest's information
     */
    public GuestDto updateGuest(Long id, GuestDto dto) {
        Guest entity = guestRepository.findById(id).orElseThrow();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setEmail(dto.getEmail());
        entity.setPassport(dto.getPassport());
        return mapper.map(guestRepository.save(entity), GuestDto.class);
    }

    /**
     * Deletes a guest.
     *
     * @param id the id of the guest to delete
     */
    public void deleteGuest(Long id) {
        guestRepository.deleteById(id);
    }

    /**
     * Retrieves all guests.
     *
     * @return a list of all guests
     */
    public List<GuestDto> getAllGuests() {
        return guestRepository.findAll().stream()
                .map(guest -> mapper.map(guest, GuestDto.class)).toList();
    }

    /**
     * Retrieves all guests with pagination.
     *
     * @param pageable the pagination information
     * @return a page of guests
     */
    public GuestPageDto getAllGuests(Pageable pageable) {
        Page<Guest> page = guestRepository.findAll(pageable);
        List<GuestDto> guests = page.stream()
                .map(guest -> mapper.map(guest, GuestDto.class)).toList();

        return new GuestPageDto(pageable.getPageNumber(), page.getTotalPages(), guests);
    }
}