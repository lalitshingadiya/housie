package com.game.housie.mapper;

import com.game.housie.dto.EventDTO;
import com.game.housie.entity.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EventMapper {
    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);
    @Mappings({
            @Mapping(target="eventId", source="eventId"),
            @Mapping(target="name", source="name"),
            @Mapping(target="eventDate", source="eventDate"),
            @Mapping(target="noOfTickets", source="noOfTickets"),
            @Mapping(target="pricePerTicket", source="pricePerTicket"),
            @Mapping(target="soldTicket", source="soldTickets"),
            @Mapping(target="noOfUsers", source="noOfUsers"),
            @Mapping(target="status", source="status")
        })
    EventDTO eventToEventDTO(Event entity);
    @Mappings({
            @Mapping(source="eventId", target="eventId"),
            @Mapping(source="name", target="name"),
            @Mapping(source="eventDate", target="eventDate"),
            @Mapping(source="noOfTickets", target="noOfTickets"),
            @Mapping(source="pricePerTicket", target="pricePerTicket"),
            @Mapping(source="soldTicket", target="soldTickets"),
            @Mapping(source="noOfUsers", target="noOfUsers"),
            @Mapping(source="status", target="status")
    })
    Event eventDTOtoEvent(EventDTO dto);
}
