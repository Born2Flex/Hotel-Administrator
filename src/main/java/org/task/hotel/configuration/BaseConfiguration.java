package org.task.hotel.configuration;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.task.hotel.guest.GuestRepository;
import org.task.hotel.rental.Rental;
import org.task.hotel.rental.dto.RentalRegistrationDto;
import org.task.hotel.room.RoomRepository;

@Configuration
public class BaseConfiguration {
    @Bean
    public ModelMapper modelMapper(@Autowired GuestRepository guestRepository, @Autowired RoomRepository roomRepository) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addConverter(new Converter<RentalRegistrationDto, Rental>() {
            @Override
            public Rental convert(MappingContext<RentalRegistrationDto, Rental> context) {
                RentalRegistrationDto source = context.getSource();
                Rental destination = context.getDestination() != null ? context.getDestination() : new Rental();
                if (source.getGuestId() != null) {
                    destination.setGuest(guestRepository.findById(source.getGuestId()).orElse(null));
                }
                if (source.getRoomId() != null) {
                    destination.setRoom(roomRepository.findById(source.getRoomId()).orElse(null));
                }
                destination.setCheckInDate(source.getCheckInDate());
                destination.setCheckOutDate(source.getCheckOutDate());

                return destination;
            }
        });
        return modelMapper;
    }
}
