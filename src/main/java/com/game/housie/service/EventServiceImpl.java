package com.game.housie.service;

import java.util.ArrayList;
import java.util.List;

import com.game.housie.dto.EventDTO;
import com.game.housie.mapper.EventMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.housie.dao.EventRepository;
import com.game.housie.entity.Event;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	EventRepository eventRepository;

	@Override
	public List<EventDTO> findAllEvents() {
		List<Event> lstevents=eventRepository.findAll();
		List<EventDTO> dtoList = new ArrayList<>();
		for(Event e:lstevents){
			dtoList.add(EventMapper.INSTANCE.eventToEventDTO(e));
		}
		return dtoList;
	}

}
