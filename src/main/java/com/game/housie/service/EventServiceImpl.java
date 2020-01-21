package com.game.housie.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.game.housie.dto.EventDTO;
import com.game.housie.entity.User;
import com.game.housie.mapper.EventMapper;
import com.game.housie.utility.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
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

	@Override
	public int save(EventDTO event) {
		Event e = EventMapper.INSTANCE.eventDTOtoEvent(event);

		Long userId=Helper.getUserId(SecurityContextHolder.getContext());

		User user1 = new User();
		user1.setId(userId);
		e.setUser(user1);
		e = eventRepository.save(e);
		return e.getEventId();
	}

	@Override
	public List<EventDTO> findAllEvents(int start, int length, String draw) {
		start=(start/length);
		Pageable p= PageRequest.of(start, length);
		Page<Event> lstevents=eventRepository.findAll(p);
		List<EventDTO> dtoList = new ArrayList<>();
		for(Event e:lstevents){
			dtoList.add(EventMapper.INSTANCE.eventToEventDTO(e));
		}
		return dtoList;
	}

	@Override
	public Long count() {
		return eventRepository.count();
	}

	@Override
	public Long count(String eventname) {
		return eventRepository.countByNameStartsWith(eventname);
	}

}
