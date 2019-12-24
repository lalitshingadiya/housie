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
//    @Mappings({
//            @Mapping(target="name", source="entity.name"),
//            @Mapping(target="nEventId", source="entity.nEventId")
//    })
    EventDTO eventToEventDTO(Event entity);
//    @Mappings({
//            @Mapping(target="id", source="dto.employeeId"),
//            @Mapping(target="name", source="dto.employeeName")
//    })
    Event eventDTOtoEvent(EventDTO dto);
}
