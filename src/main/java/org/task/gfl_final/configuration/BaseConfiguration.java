package org.task.gfl_final.configuration;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.task.gfl_final.guest.GuestEntity;
import org.task.gfl_final.guest.GuestRepository;
import org.task.gfl_final.rental.Rental;
import org.task.gfl_final.rental.dto.RentalRegistrationDTO;
import org.task.gfl_final.room.Room;
import org.task.gfl_final.room.RoomRepository;

import java.time.LocalDate;

@Configuration
public class BaseConfiguration {
    @Bean
    public ModelMapper modelMapper(@Autowired GuestRepository guestRepository, @Autowired RoomRepository roomRepository) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addConverter(new Converter<RentalRegistrationDTO, Rental>() {
            @Override
            public Rental convert(MappingContext<RentalRegistrationDTO, Rental> context) {
                RentalRegistrationDTO source = context.getSource();
                Rental destination = context.getDestination() != null ? context.getDestination() : new Rental();
                if (source.getGuestId() != null) {
//                    GuestEntity guest = new GuestEntity();
//                    guest.setId(source.getGuestId());
                    destination.setGuest(guestRepository.findById(source.getGuestId()).orElse(null));
                }
                if (source.getRoomId() != null) {
//                    Room room = new Room();
//                    room.setId(source.getRoomId());
                    destination.setRoom(roomRepository.findById(source.getRoomId()).orElse(null));
                }
                destination.setStartDate(source.getStartDate());
                destination.setEndDate(source.getEndDate());
                destination.setTotalPrice(source.getTotalPrice());

                return destination;
            }
        });
        return modelMapper;
    }
}
