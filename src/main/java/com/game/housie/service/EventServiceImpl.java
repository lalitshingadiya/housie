package com.game.housie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.housie.dao.EventRepository;
import com.game.housie.entity.Event;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	EventRepository eventRepository;
	
	@Override
	public List<Event> findAllEvents() {
		List<Event> lstevents=eventRepository.findAll();
		return lstevents;
	}

}
