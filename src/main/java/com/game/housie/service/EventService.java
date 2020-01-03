package com.game.housie.service;

import java.util.List;

import com.game.housie.dto.EventDTO;
import com.game.housie.entity.Event;

public interface EventService {
	
	List<EventDTO> findAllEvents();

	public int save(EventDTO e);
}
