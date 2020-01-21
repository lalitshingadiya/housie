package com.game.housie.service;

import java.util.List;

import com.game.housie.dto.EventDTO;
import com.game.housie.entity.Event;
import org.springframework.data.domain.Pageable;

public interface EventService {
	
	List<EventDTO> findAllEvents();
	public int save(EventDTO e);

	List<EventDTO> findAllEvents(int start, int length, String draw);

	public Long count();
	public Long count(String eventname);

	//@Query("SELECT COUNT(u) FROM User u WHERE u.name=:name")
	//Long aMethodNameOrSomething(@Param("name") String name);

}
