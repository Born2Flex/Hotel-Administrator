package org.task.gfl_final.guest;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.task.gfl_final.guest.dto.GuestShortDTO;
import org.task.gfl_final.guest.dto.GuestRegistrationDTO;

import java.util.List;

@Service
@AllArgsConstructor
public class GuestService {
    private GuestRepository guestRepository;
    private ModelMapper mapper;

    public GuestShortDTO registerGuest(GuestRegistrationDTO dto) {
        Guest entity = guestRepository.save(mapper.map(dto, Guest.class));
        return mapper.map(entity, GuestShortDTO.class);
    }

    public List<GuestShortDTO> getGuestsByLastName(String lastName) {
        return guestRepository.findByLastNameLikeIgnoreCase(lastName).stream()
                .map(guest -> mapper.map(guest, GuestShortDTO.class)).toList();
    }
//
//    public List<GuestShortDTO> getGuestsByFirstName(String firstName) {
//        return guestRepository.findByFirstNameIgnoreCase(firstName).stream()
//                .map(guest -> mapper.map(guest, GuestShortDTO.class)).toList();
//    }
//
//    public GuestShortDTO getGuestsByPhoneNum(String phoneNum) {
//        return mapper.map(guestRepository.findByPhoneNumber(phoneNum), GuestShortDTO.class);
//    }
//
//    public GuestShortDTO getGuestsByEmail(String email) {
//        return mapper.map(guestRepository.findByEmail(email), GuestShortDTO.class);
//    }
//
//    public GuestShortDTO getGuestsByPassport(String passport) {
//        return mapper.map(guestRepository.findByPassport(passport), GuestShortDTO.class);
//    }
}
