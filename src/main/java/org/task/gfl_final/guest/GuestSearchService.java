package org.task.gfl_final.guest;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.task.gfl_final.guest.Guest;
import org.task.gfl_final.guest.GuestRepository;
import org.task.gfl_final.guest.dto.GuestDto;
import org.task.gfl_final.guest.dto.GuestPageDto;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

@Service
public class GuestSearchService {
    private final Map<String, BiFunction<String, Pageable, Page<Guest>>> searchCriteria;
    private final ModelMapper modelMapper;

    public GuestSearchService(GuestRepository guestRepository, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.searchCriteria = Map.of(
                "LAST_NAME", guestRepository::findByLastNameLikeIgnoreCase,
                "FIRST_NAME", guestRepository::findByFirstNameIgnoreCase,
                "EMAIL", guestRepository::findByEmailIgnoreCase,
                "PHONE", guestRepository::findByPhoneNumber,
                "PASSPORT", guestRepository::findByPassport
        );
    }

    public GuestPageDto search(String criteria, String value, Pageable pageable) {
        if (!searchCriteria.containsKey(criteria)) {
            throw new IllegalArgumentException("Invalid search criteria");
        }
        Page<Guest> page = searchCriteria.get(criteria).apply(value, pageable);
        List<GuestDto> guests = page.get().map(guest -> modelMapper.map(guest, GuestDto.class)).toList();
        return new GuestPageDto(pageable.getPageNumber(), page.getTotalPages(), guests);
    }
}
