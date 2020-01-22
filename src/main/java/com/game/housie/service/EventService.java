package com.game.housie.service;

import java.util.List;
import java.util.Map;

import com.game.housie.dto.EventDTO;
import com.game.housie.entity.Event;
import org.json.JSONObject;
import org.springframework.data.domain.Pageable;

public interface EventService {
	
	List<EventDTO> findAllEvents();
	public Long save(EventDTO e);

	JSONObject findAllEvents(Map map);
	Event getEventById(Long id);

	public Long count();
	public Long count(String eventname);


}
