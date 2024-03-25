package org.task.gfl_final.guest;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.task.gfl_final.guest.Guest;
import org.task.gfl_final.guest.GuestRepository;
import org.task.gfl_final.guest.dto.GuestDto;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
public class GuestSearchService {
    private final Map<String, Function<String, List<Guest>>> searchCriteria;
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

    //TODO Add custom exception
    public List<GuestDto> search(String criteria, String value) {
        if (!searchCriteria.containsKey(criteria)) {
            throw new IllegalArgumentException("Invalid search criteria");
        }
        return searchCriteria.get(criteria).apply(value).stream()
                .map(element -> modelMapper.map(element, GuestDto.class)).toList();
    }
}
