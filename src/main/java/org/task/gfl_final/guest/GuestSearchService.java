package org.task.gfl_final.guest;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.task.gfl_final.guest.dto.GuestDto;
import org.task.gfl_final.guest.dto.GuestPageDto;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * Service for searching guests based on various criteria.
 */
@Service
public class GuestSearchService {
    private final Map<String, BiFunction<String, Pageable, Page<Guest>>> searchCriteria;
    private final ModelMapper modelMapper;

    /**
     * Constructs a new GuestSearchService.
     *
     * @param guestRepository the repository to use for searching guests
     * @param modelMapper     the model mapper to use for converting entities to DTOs
     */
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

    /**
     * Searches for guests based on the given criteria and value.
     *
     * @param criteria the criteria to search by
     * @param value    the value to search for
     * @param pageable the pagination information
     * @return a page of guests that match the search criteria
     * @throws IllegalArgumentException if the given criteria is not valid
     */
    public GuestPageDto search(String criteria, String value, Pageable pageable) {
        if (!searchCriteria.containsKey(criteria)) {
            throw new IllegalArgumentException("Invalid search criteria");
        }
        Page<Guest> page = searchCriteria.get(criteria).apply(value, pageable);
        List<GuestDto> guests = page.get().map(guest -> modelMapper.map(guest, GuestDto.class)).toList();
        return new GuestPageDto(pageable.getPageNumber(), page.getTotalPages(), guests);
    }
}